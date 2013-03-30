package net.trololo.Level;

public class Level {
    Terrain terrain;
    
    public Level() {
        terrain = new Terrain(100, 100);
        terrain.generate();
    }
    
    public void render() {
        terrain.render();
    }
    
    public void update() {
        
    }
    
}
