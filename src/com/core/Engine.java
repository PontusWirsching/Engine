package com.core;

public abstract class Engine implements Runnable {

	public static int WIDTH, HEIGHT;
	public static String TITLE;

	public Thread thread;
	
	public Engine(int width, int height, String title) {

	}
	
	
	
	/**
	 * Event that calls when engine stopped.
	 */
	public void onExit() {
		
	}
	
	/**
	 * Call it to start the engine.
	 */
	public void start() {
		
	}
	
	/**
	 * Do all setup from here.
	 */
	public void setup() {
		
	}
	
	/**
	 * Sets up the JFrame and adds the OpenGL element to it.
	 */
	public void frameSetup() {
		
	}
	
	/**
	 * Graphics setup here.
	 */
	public void setupOpenGL() {
		
	}

	/**
	 * Event based method on resize.
	 */
	public void resize() {

	}

	/**
	 * Render loop.
	 */
	public void run() {
		
	}
	
	/**
	 * Handle background graphic stuff.
	 */
	public void draw() {
		
	}
	
	public abstract void update();
	
	public abstract void render();

}
