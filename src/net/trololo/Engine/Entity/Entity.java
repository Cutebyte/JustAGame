package net.trololo.Engine.Entity;

public class Entity {
	// + vars
	int xPos;
	int yPos;
	int wSiz;
	int hSiz;
	float xVel;
	float yVel;
	//int xTex;
	//int yTex;
	
	// - vars
	
	public Entity( int x, int y, int w, int h) {
		xPos = x;
		yPos = y;
		wSiz = w;
		hSiz = h;
	}
	
	public void setPos( int x, int y ) {
		xPos = x;
		yPos = y;
	}
	
	public void applyForce( float x, float y ) {
		xVel += x;
		yVel += y;
	}
	
	public void setForce( float x, float y ) {
		xVel = x;
		yVel = y;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public int getW() {
		return wSiz;
	}
	
	public int getH() {
		return hSiz;
	}
	
	public float getXForce() {
		return xVel;
	}
	
	public float getYForce() {
		return yVel;
	}
	
	public void updatePos() {
		xPos += xVel;
		yPos += yVel;
		if( Math.abs(xVel) > 1 ) xVel /= 1.15; else xVel = 0;
		if( Math.abs(yVel) > 1 ) yVel /= 1.15; else yVel = 0;
	}
}
