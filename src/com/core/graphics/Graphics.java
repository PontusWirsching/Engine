package com.core.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Graphics {

	public static void drawCube(float x, float y, float z, float width, float height, float depth) {
		
		x -= width / 2;
		y -= height / 2;
		z -= depth / 2;
		
		glBegin(GL_QUADS);
		{
			
			float w = width;
			float h = height;
			float d = depth;
			
			//Front face
			glColor3d(0, 1, 0);
			glVertex3f(x, y, z);
			glVertex3f(x + w, y, z);
			glVertex3f(x + w, y + h, z);
			glVertex3f(x, y + h, z);
			
			//Right face
			glColor3d(1, 0, 0);
			glVertex3f(x + w, y, z);
			glVertex3f(x + w, y, z - d);
			glVertex3f(x + w, y + h, z - d);
			glVertex3f(x + w, y + h, z);

		}
		glEnd();
		
	}
	
}
