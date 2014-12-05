package com.core.graphics;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.vector.Vector3f;

public class Graphics {

	public static void drawCube(Vector3f pos, Vector3f size) {

		float x = pos.x, y = pos.y, z = pos.z, w = size.x, h = size.y, d = size.z;

		x -= w / 2;
		y -= h / 2;
		z += d / 2;

		glBegin(GL_QUADS);
		{

			// Front face
			glColor4d(0, 1, 0, 0.0);
			glVertex3f(x, y, z);
			glVertex3f(x + w, y, z);
			glVertex3f(x + w, y + h, z);
			glVertex3f(x, y + h, z);

			// Right face
			glColor3d(1, 0, 0);
			glVertex3f(x + w, y, z);
			glVertex3f(x + w, y, z - d);
			glVertex3f(x + w, y + h, z - d);
			glVertex3f(x + w, y + h, z);

			// Left face
			glColor3d(0, 0, 1);
			glVertex3f(x, y, z - d);
			glVertex3f(x, y, z);
			glVertex3f(x, y + h, z);
			glVertex3f(x, y + h, z - d);

			// Top face
			glColor3d(1, 0, 1);
			glVertex3f(x, y + h, z);
			glVertex3f(x, y + h, z - d);
			glVertex3f(x + w, y + h, z - d);
			glVertex3f(x + w, y + h, z);

			// Bottom face
			glColor3d(0, 1, 1);
			glVertex3f(x, y, z);
			glVertex3f(x, y, z - d);
			glVertex3f(x + w, y, z - d);
			glVertex3f(x + w, y, z);

			// Back face
			glColor3d(1, 1, 0);
			glVertex3f(x, y, z - d);
			glVertex3f(x + w, y, z - d);
			glVertex3f(x + w, y + h, z - d);
			glVertex3f(x, y + h, z - d);
		}
		glEnd();

	}

}
