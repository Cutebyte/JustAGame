package net.trololo.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;


public class Terrain {
    private class Miner {
        int x; 
        int y; 
        int dir; 
        boolean alive; 
        
        public Miner(int x, int y, int dir) {
            this.x = x; 
            this.y = y; 
            this.dir = dir;
            this.alive = true; 
        }
        
        // 0 up 
        // 1 right
        // 2 down
        // 3 left
        
        public boolean turnLeft() {
            if(dir == 0) {
                dir = 3; 
                return true;
            }
            dir--;
            return true;
        }
        
        public boolean turnRight() {
            if(dir == 3) {
                dir = 0; 
                return true;
            }
            dir++;
            return true;
        }
    }
    
    Random rand;

    public boolean tilesList[]; 
    int sizeX, sizeY;
    List<Tile> tiles;
    
    private boolean roll() {
        return rand.nextBoolean();
    }
    
    public Terrain(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
        
        this.tilesList = new boolean[x*y];
        for(int i = 0; i<sizeX*sizeY; i++) {
            this.tilesList[i] = false;
        }
        
        rand = new Random();
        tiles = new ArrayList<Tile>();
    }
    
    private boolean checkTile(int x, int y) {
        if(x < 0 || y < 0 || x > sizeX || y > sizeY)
            return false;
        return tilesList[x * sizeX + y];
    }
    
    private boolean setTile(int x, int y) {
        tilesList[x * sizeX + y] = true; 
        return true;
    }
    
    private boolean checkBorder(int x, int y) {
        return !(x < 1 || y < 1 || x > sizeX - 1 || y >sizeY);
    }
    
    private boolean checkMiner(Miner miner) {
        if(miner.dir == 0) {
            return checkBorder(miner.x, miner.y + 1);
        }
        if(miner.dir == 2) {
            return checkBorder(miner.x, miner.y - 1);
        }
        if(miner.dir == 1) {
            return checkBorder(miner.x + 1, miner.y);
        }
        if(miner.dir == 3) {
            return checkBorder(miner.x - 1, miner.y);
        }
        return false; 
    }
    
    private boolean turn(Miner miner) {
        if(roll()) 
            miner.turnLeft();
        else
            miner.turnRight();
        return true;
    }
    
    private boolean go(Miner miner) {
        if(miner.dir == 0) {
            miner.y++;
        }
        if(miner.dir == 2) {
            miner.y--;
        }
        if(miner.dir == 1) {
            miner.x++;
        }
        if(miner.dir == 3) {
            miner.x--;
        }
        
        if(checkTile(miner.x, miner.y)) {
            return false; 
        }
        return setTile(miner.x, miner.y);
    }

    public void generate() {
        boolean generating = true; 
        
        int tunelCount = rand.nextInt(25) + 10;
        int size = 0; 
        
        int initialX = rand.nextInt(sizeX - 10) + 5;
        int initialY = rand.nextInt(sizeY - 10) + 5;
        
        Miner miner = new Miner(initialX, initialY, rand.nextInt(4));
        
        while(generating) {
            
            
            if(rand.nextInt(300) > 399) {
                turn(miner);
            }
            if(checkMiner(miner)) {
                turn(miner);
            }
            miner.alive = go(miner);
            if(rand.nextInt(500) > 499) {
                miner.alive = false;
            }
           
            
            if(!miner.alive) {
                Tile tileTemp = tiles.get(rand.nextInt(tiles.size()));
                miner = new Miner(tileTemp.x, tileTemp.y, rand.nextInt(4));
                size++;
            } else {
                tiles.add(new Tile(miner.x, miner.y));
            }
            
            if(size > tunelCount)
                generating = false;
        }
    }
    
    public void render() {
        for(int i = 0; i<sizeX; i++) {
            for(int j = 0; j<sizeY; j++) {
                final int width = 3; 
                final int height = 3; 
                
                int x = i * height;
                int y = j * width;

                GL11.glPushMatrix();
                GL11.glTranslatef(0, 0, 0.0f);
                
                if(checkTile(i, j)) 
                    GL11.glColor3f(1.f, 0.f, 0.f);
                else
                    GL11.glColor3f(1.f, 0.f, 1.f);
                
                GL11.glBegin(GL11.GL_QUADS);
                    GL11.glVertex2i( x, y );
                    GL11.glVertex2i( x + height, y );
                    GL11.glVertex2i( x + height, y + width );
                    GL11.glVertex2i( x, y + width);
                GL11.glEnd();

                GL11.glPopMatrix();
            }
        }
    }
    
    public void update() {
        
    }
    
}
