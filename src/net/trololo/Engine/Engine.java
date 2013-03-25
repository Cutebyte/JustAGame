package net.hopskocz.Engine;

import net.hopskocz.Engine.Keyboard.KeysCtl;
import net.hopskocz.Engine.Renderer.Renderer;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Engine {
	
	//Variables
	boolean finished;
	
	public KeysCtl keyboard;
	public Renderer renderer;
	
	public Engine() {
		finished = false;
		keyboard = new KeysCtl();
		renderer = new Renderer();
	}
	
	public int init() throws LWJGLException {
		Display.setTitle( "Menda" ); //setting window title
		
		Display.setVSyncEnabled(true);
		//Display.setDisplayMode(new DisplayMode(640,480));
		Display.setFullscreen( true );
		Display.create();
		
		Keyboard.enableRepeatEvents(false);
		
		// + OpenGL initialization
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		
		GL11.glOrtho(0, Display.getDisplayMode().getWidth(), 0, Display.getDisplayMode().getHeight(), -1, 1);
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		
		
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.4f);
		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_COLOR_BUFFER_BIT);
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		// - OpenGL initialization
		
		// + Game init things
		
		//TEST TODO: REMOVE
		
		
		// - Game init things
		
		return 0;
	}
	
	public void cleanup() // cleaning all things 
	{
		Display.destroy();
	}
	
	public void initX() {
		//boolean fullscreen = (args.length == 1 && args[0].equals("-fullscreen"));
		try
		{
			init();
			//run(); moved to game class
		}
		catch( Exception e)
		{
			e.printStackTrace(System.err);
			Sys.alert( "OH NOEH", "Something went wrong. Can't start the game!" );
		}
		finally
		{
			cleanup();
		}
		//System.exit(0);
	}
	
	public void run() // main loop
	{
		// + declarations etc
		//boolean finished = false;
		// - declarations etc
		//while(!finished)
		{
			Display.update(); // update teh screen
			if(Display.isCloseRequested()) // if want to close, then end the main loop
			{
				finish();
			}
			else if(Display.isActive()) // if window is active, then do everything what game should
			{
				//logic();
				keyboard.updateKeys();
				renderer.render();
				Display.sync(60);
			}
			else // if not active, then sleep
			{
				try
				{
					Thread.sleep(100);
					
				} catch( InterruptedException e) {}
				//logic();
				if(Display.isVisible() || Display.isDirty()) // render if game windows is partly or full visible
				{
					renderer.render();
				}
			}
		}
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public void finish() {
		finished = true;
	}
	
	/*
	private static void logic() // do all logics like keyboard handle, physics, collision detection
	{

	} 
	*/
}

