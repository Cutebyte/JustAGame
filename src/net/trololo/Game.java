package net.trololo;

import net.trololo.Engine.Engine;
import net.trololo.Engine.Entity.Entity;

import org.lwjgl.LWJGLException;


public class Game {

	public static void main(String[] args) {
		Engine engine = new Engine( "Just a game" );
	try {
		engine.init();
		
		Entity block = new Entity( 32, 64, 32, 32 );
		Entity block2 = new Entity( 256, 64, 32, 32 );
		engine.renderer.addToList( block );
		engine.renderer.addToList( block2 );
		
		while( !engine.isFinished() ) {
			engine.run();
			if( engine.keyboard.isDown(0) ) engine.finish();
			/*
			if( engine.keyboard.isDown(1) ) block.setPos( block.getX(), block.getY()+3 );
			if( engine.keyboard.isDown(2) ) block.setPos( block.getX(), block.getY()-3 );
			if( engine.keyboard.isDown(3) ) block.setPos( block.getX()-3, block.getY() );
			if( engine.keyboard.isDown(4) ) block.setPos( block.getX()+3, block.getY() ); */
			if( engine.keyboard.isDown(1) ) block.setForce( block.getXForce(), 10 );
			if( engine.keyboard.isDown(2) ) block.setForce( block.getXForce(), -10 );
			if( engine.keyboard.isDown(3) ) block.setForce( -10, block.getYForce() );
			if( engine.keyboard.isDown(4) ) block.setForce( 10, block.getYForce() );
			if( engine.keyboard.isDown(11) ) block2.setForce( block2.getXForce(), 10 );
			if( engine.keyboard.isDown(12) ) block2.setForce( block2.getXForce(), -10 );
			if( engine.keyboard.isDown(13) ) block2.setForce( -10, block2.getYForce() );
			if( engine.keyboard.isDown(14) ) block2.setForce( 10, block2.getYForce() );
			block.updatePos();
			block2.updatePos();
		}
		
		
	} catch (LWJGLException e) {
		e.printStackTrace();
	}
	finally {
		engine.cleanup();
	}
	engine.cleanup();
	}

}
