package net.trololo.Engine.Renderer;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.GL11;

import net.trololo.Engine.Entity.Entity;

public class Renderer {
	ArrayList<Entity> renderList;
	
	public Renderer() {
		renderList = new ArrayList<Entity>();
	}
	//TO JE TO CO DODAŁEM :D
	public void addToList( Entity entity ) {
		System.out.print("Chleb");
		renderList.add( entity );
	}
	
	public void render() {
		//GL11.glTranslatef(0, 0, 0);
		
		Entity e;
		
		GL11.glClearColor(0.0f, 0.5f, 0.2f, 1.0f);
		
		for( Iterator<Entity> itr = renderList.iterator(); itr.hasNext();) {
			e = itr.next();
			GL11.glPushMatrix();
			GL11.glTranslatef(0, 0, 0.0f);
			GL11.glColor3f(0.f, 1.f, 0.f);
			
			GL11.glBegin(GL11.GL_QUADS);
				GL11.glVertex2i( e.getX(), e.getY() );
				GL11.glVertex2i( ( e.getX()+e.getW() ), e.getY() );
				GL11.glVertex2i( ( e.getX()+e.getW() ), ( e.getY()-e.getH() ));
				GL11.glVertex2i( e.getX(), ( e.getY()-e.getH() ));
			GL11.glEnd();

			GL11.glPopMatrix();
		}
	}
}
