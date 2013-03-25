package net.hopskocz.Engine.Keyboard;

import org.lwjgl.input.Keyboard;

public class KeyConf {
	
	int nKeys = 20;
	
	int key[] = new int[nKeys];
	boolean lock[] = new boolean[nKeys];
	
	public KeyConf() {
		//default set of keys
		key[0] = Keyboard.KEY_ESCAPE;
		key[1] = Keyboard.KEY_W;
		key[2] = Keyboard.KEY_S;
		key[3] = Keyboard.KEY_A;
		key[4] = Keyboard.KEY_D;
		//sec player
		key[11] = Keyboard.KEY_UP;
		key[12] = Keyboard.KEY_DOWN;
		key[13] = Keyboard.KEY_LEFT;
		key[14] = Keyboard.KEY_RIGHT;
	}
	
	public int changeKey( int id, int keybKeyId ) {
		if( id < nKeys && id >= 0 ) {
			key[id] = keybKeyId;
			return 0;
		} else
			return -1;
	}
	
	public int getKeyNumber(  ) {
		return nKeys;
	}
	
	public int getKey( int id ) {
		if( id < nKeys && id >= 0 ) {
			return key[id];
		} else
			return -1;
	}
	
	public void lock( int id ) {
		if( id < nKeys && id >= 0 ) {
			lock[id] = true;
		}
	}
	
	public void unlock( int id ) {
		if( id < nKeys && id >= 0 ) {
			lock[id] = false;
		}
	}
	
	public boolean isLocked( int id ) {
		if( id < nKeys && id >= 0 ) {
			return lock[id];
		} else
			return false;
	}
	
	
	
}
