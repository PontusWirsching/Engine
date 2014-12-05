package com.core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.lwjgl.opengl.Display;

public abstract class Engine implements Runnable {

	public static int WIDTH, HEIGHT;
	public static String TITLE;

	public Thread thread;

	/**
	 * Frame that holds everything together.
	 */
	public Frame frame;

	/**
	 * Canvas used for applying the OpenGL.
	 */
	private Canvas canvas;

	/**
	 * Is the close button pressed?
	 */
	public boolean closeRequested = false;

	private boolean running = false;
	
	public Engine(int width, int height, String title) {
		TITLE = title;
		WIDTH = width;
		HEIGHT = height;
		setup();
	}

	/**
	 * Event that calls when engine stopped.
	 */
	public void onExit() {
		running = false;
	}

	/**
	 * Call it to start the engine.
	 */
	public void start() {
		running = true;
		frame.setVisible(true);
	}

	/**
	 * Do all setup from here.
	 */
	public void setup() {
		frameSetup();
	}

	/**
	 * Sets up the JFrame and adds the OpenGL element to it.
	 */
	public void frameSetup() {
		
		frame = new Frame(TITLE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeRequested = true;
			}
		});
		canvas = new Canvas();
		frame.add(canvas, BorderLayout.CENTER);

		try {

			Display.setParent(canvas);
	        Display.setVSyncEnabled(true);
	        frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
			frame.setLocationRelativeTo(null);

	        
	        frame.pack();
			
	        Display.create();
	        
		} catch (Exception e) {

		}

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
		long LT = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - LT) / ns;
			LT = now;
			while(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + ", UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		onExit();
	}

	/**
	 * Handle background graphic stuff.
	 */
	public void draw() {

	}

	public abstract void update();

	public abstract void render();

}
