package net.trololo.Engine.TextureBank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class TextureBank {
	private HashMap<String, Texture> textures = new HashMap<String, Texture>();
	
	public boolean LoadTexture(String path, String name)
	{
		Texture texture;
		
		try {
			if((texture = TextureLoader.getTexture("PNG", new FileInputStream(path))) != null)
			{
				textures.put(name,texture);
				return true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Texture GetTexture(String name)
	{
		if(textures.containsKey(name))
		{
			return textures.get(name);
		}
		return null;
	}
	
}