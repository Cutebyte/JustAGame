package net.trololo.Engine.Entity;

import net.trololo.Engine.Keyboard.KeysCtl;
import net.trololo.Engine.Physics.Physics;
import net.trololo.Engine.Renderer.Renderer;

public class Player extends Entity{
	
	KeysCtl keyboard;
	
	int keyUp;
	int keyDown;
	int keyLeft;
	int keyRight;
	int keyAttack;
	
	public Player( int x, int y, int w, int h, KeysCtl inKeyboard, Renderer render, Physics physics ) {
		xPos = x;
		yPos = y;
		wSiz = w;
		hSiz = h;
		keyboard = inKeyboard;
		
		keyUp = 1;
		keyDown = 2;
		keyLeft = 3;
		keyRight = 4;
		keyAttack = 5;
		
		render.addToList( this );
		physics.addToList( this );
	}
	
	public Player( int x, int y, int w, int h, KeysCtl inKeyboard, Renderer render, Physics physics, int ctrlSet ) {
		xPos = x;
		yPos = y;
		wSiz = w;
		hSiz = h;
		keyboard = inKeyboard;
		
		switch( ctrlSet ) {
			case 1 :
				keyUp = 11;
				keyDown = 12;
				keyLeft = 13;
				keyRight = 14;
				keyAttack = 15; break;
			default :
				keyUp = 1;
				keyDown = 2;
				keyLeft = 3;
				keyRight = 4;
				keyAttack = 5; break;
		}
		
		render.addToList( this );
		physics.addToList( this );
	}
	
	void changeKeys( int which, int newKey ) {
		switch( which ) {
			case 1 : keyUp = newKey; break;
			case 2 : keyDown = newKey; break;
			case 3 : keyLeft = newKey; break;
			case 4 : keyRight = newKey; break;
			case 5 : keyAttack = newKey; break;
		}
	}
	
	public void control(  ) {
		if( keyboard.isDown( keyUp ) ) setForce( getXForce(), 3 );
		if( keyboard.isDown( keyDown ) ) setForce( getXForce(), -3 );
		if( keyboard.isDown( keyLeft ) ) setForce( -3, getYForce() );
		if( keyboard.isDown( keyRight ) ) setForce( 3, getYForce() );
	}
}
