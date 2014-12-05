package com.core.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Graphics {

	public static void drawCube(float x, float y, float z, float width, float height, float depth) {
		
		glBegin(GL_QUADS);
		{
			
			float w = width;
			float h = height;
			float d = depth;
			
			//Front face
			glVertex3f(x, y, z);
			glVertex3f(x + w, y, z);
			glVertex3f(x + w, y + h, z);
			glVertex3f(x, y + h, z);

		}
		glEnd();
		
	}
	
}
