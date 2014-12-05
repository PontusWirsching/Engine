import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

import com.core.Engine;
import com.core.graphics.Graphics;

public class Main extends Engine {

	public Main(int width, int height, String title) {
		super(width, height, title);

		start();
	}

	@Override
	public void customSetup() {

	}
	
	@Override
	public void update() {

	}

	double delta = 0;

	@Override
	public void render() {
		delta++;
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		
		float x = 0;
		float y = 0;
		float z = -4;
		
		
		glTranslatef(x, y, z);
		
		glPushMatrix();
		{
			glRotated(delta, 1, 0, 0);
			glRotated(delta, 0, 1, 0);
			glRotated(delta, 0, 0, 1);

			glBegin(GL_POINTS);
			
				glVertex3i(0, 0, 0);
			
			glEnd();
			
			Graphics.drawCube(0, 0, 0, 1, 1, 1);

		}
		glPopMatrix();
		
		

		glTranslatef(-x, -y, -z);
	}

	public static void main(String[] args) {
		new Main(1280, 720, "First Engine Test");
	}

}
