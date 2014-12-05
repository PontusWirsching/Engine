package com.core;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public abstract class Engine implements Runnable {

	public int width, height;

	public Thread thread;

	public Engine(int width, int height, String title) {

		this.width = width;
		this.height = height;

		thread = new Thread(this, "main_thread");

	}

	/**
	 * Method used for overriding.
	 */
	public void customSetup() {
		
	}
	
	public void start() {
		thread.start();
	}

	public void run() {
		try {

			setupDisplay();
			setupOpenGL();

			customSetup();
			
			int frames = 0;
			int fps = 0;
			long timer = System.currentTimeMillis();

			while (!Display.isCloseRequested()) {

				frames++;

				render();

				Display.update();
				Display.sync(120);

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

		/* OpenGL */
		int width = Display.getDisplayMode().getWidth();
		int height = Display.getDisplayMode().getHeight();

		GL11.glViewport(0, 0, width, height); // Reset The Current Viewport
		GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
		GL11.glLoadIdentity(); // Reset The Projection Matrix
		GLU.gluPerspective(45.0f, ((float) width / (float) height), 0.1f, 100.0f); // Calculate The Aspect Ratio Of The Window
		GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix
		GL11.glLoadIdentity(); // Reset The Modelview Matrix

		GL11.glShadeModel(GL11.GL_SMOOTH); // Enables Smooth Shading
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
		GL11.glClearDepth(1.0f); // Depth Buffer Setup
		GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
		GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Test To Do
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST); // Really Nice Perspective Calculations
	}

	public abstract void update();

	public abstract void render();

}
