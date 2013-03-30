package net.trololo.Engine.Physics;

import java.util.ArrayList;
import java.util.Iterator;

import net.trololo.Engine.Entity.Entity;

public class Physics {
	float gravity = 1.6f;
	ArrayList<Entity> physList;
	
	public Physics() {
		physList = new ArrayList<Entity>();
	}
	
	public void addToList( Entity e ) {
		physList.add( e );
	}
	
	public void clearList( Entity e ) {
		physList.clear();
	}
	
	public void applyPhysics() {
		for( Iterator<Entity> itr = physList.iterator(); itr.hasNext(); ) {
			Entity e = itr.next();
			if( e.isFalling() ) e.applyForce( 0, -gravity );
			e.updatePos();
		}
	}
	
	public void changeGravity( float gravityIn ) {
		gravity = gravityIn;
	}
}
