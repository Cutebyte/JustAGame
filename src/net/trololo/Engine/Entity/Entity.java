package net.trololo.Engine.Entity;

import java.util.ArrayList;

import net.trololo.Engine.Physics.Physics;
import net.trololo.Engine.Renderer.Renderer;

public class Entity {
	
	// Position
	int xPos;
	int yPos;
	
	// Size
	int wSiz;
	int hSiz;
	
	// Velocity
	float xVel;
	float yVel;
	
	//Texturing stuff
	String texture;
	int xTex;
	int yTex;
	
	// Physics stuff
	boolean pushable = false;
	
	// Collision list
	ArrayList<Entity> collisionList;
	
	public Entity() {
		
	}
	
	public Entity( int x, int y, int w, int h, Renderer render, int inXTex, int inYTex, String inTexture ) {
		xPos = x;
		yPos = y;
		wSiz = w;
		hSiz = h;
		render.addToList( this );
		
		texture = inTexture;
		xTex = inXTex;
		yTex = inYTex;
	}
	
	public Entity( int x, int y, int w, int h, Renderer render, Physics physics, int inXTex, int inYTex, String inTexture ) {
		xPos = x;
		yPos = y;
		wSiz = w;
		hSiz = h;
		render.addToList( this );
		physics.addToList( this );
		pushable = true;
		
		texture = inTexture;
		xTex = inXTex;
		yTex = inYTex;
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
		if( Math.abs(xVel) > 0.5f ) xVel /= 1.15; else xVel = 0;
		if( Math.abs(yVel) > 0.5f ) yVel /= 1.15; else yVel = 0;
	}
	
	public void addToCollisionList( Entity entity ) {
		collisionList.add( entity );
	}
	
	//public boolean isFalling() {
	//	return falling;
	//}
}
