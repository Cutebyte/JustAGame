package net.trololo;

import net.trololo.Engine.Engine;
import net.trololo.Engine.Entity.Player;

import org.lwjgl.LWJGLException;


public class Game {

	public static void main(String[] args) {
		Engine engine = new Engine( "Slay them all" );
	try {
		engine.init();
		
		Player player = new Player( 32, 64, 32, 32, engine.keyboard, engine.renderer, engine.physics );
		Player player2 = new Player( 64, 64, 32, 32, engine.keyboard, engine.renderer, engine.physics, 1);
		player.addToCollisionList( player2 );
		player2.addToCollisionList( player );
		
		while( !engine.isFinished() ) {
			engine.run();
			if( engine.keyboard.isDown(0) ) engine.finish();
			player.control();
			player2.control();
			// fun stuff
			if( player.getX() < -32 ) player.setPos( 640, player.getY() );
			if( player.getX() > 640 ) player.setPos( -32, player.getY() );
			if( player.getY() < 0 ) player.setPos( player.getX(), 512 );
			if( player.getY() > 512 ) player.setPos( player.getX(), 0 );
			
			if( player2.getX() < -32 ) player2.setPos( 640, player2.getY() );
			if( player2.getX() > 640 ) player2.setPos( -32, player2.getY() );
			if( player2.getY() < 0 ) player2.setPos( player2.getX(), 512 );
			if( player2.getY() > 512 ) player2.setPos( player2.getX(), 0 );
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
