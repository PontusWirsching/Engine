
package com.core;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public abstract class Engine implements Runnable {

	public int width, height;

	public Thread thread;
	
	public Engine(int width, int height, String title) {

		this.width = width;
		this.height = height;

		thread = new Thread(this, "main_thread");
		
	}
	
	public void start() {
		thread.start();
	}

	public void run() {
		try {			

			setupDisplay();
			setupOpenGL();

			int frames = 0;
			int fps = 0;
			long timer = System.currentTimeMillis();
			
			while (!Display.isCloseRequested()) {
				
				frames++;
				
				render();
				
				Display.update();
				
				
				
				if (System.currentTimeMillis() > timer + 1000) {
					timer = System.currentTimeMillis();
					fps = frames;
					frames = 0;
					System.out.println("FPS: " + fps);
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setupDisplay() throws Exception {
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.create();
	}
	
	public void setupOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glViewport(0, 0, width, height);
		glLoadIdentity();
		gluPerspective((float) 80,(float)(width)/(float)height, 0.001f, 1000f);
//		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}

	public abstract void update();

	public abstract void render();

}
