package net.trololo.Engine.Keyboard;

import org.lwjgl.input.Keyboard;

public class KeysCtl {
	
	public KeyConf keys;
	
	public KeysCtl() {
		keys = new KeyConf();
	}
	
	public void updateKeys() {
		for( int i = 0; i < keys.getKeyNumber(); i++) {
			if( Keyboard.isKeyDown( keys.getKey( i ))) {
				if( !keys.isLocked( i ) ) {
					keys.lock( i );
				}
			} else
				keys.unlock( i );
		}
	}
	
	public boolean isDown( int id ) {
		return keys.isLocked( id );
	}
}
