import static org.lwjgl.opengl.GL11.*;

import com.core.Engine;
import com.core.graphics.Graphics;

public class Main extends Engine {

	public Main(int width, int height, String title) {
		super(width, height, title);

		start();
	}

	@Override
	public void update() {

	}

	double delta = 0;

	@Override
	public void render() {
		delta++;
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		float x = (float)(Math.sin(delta / 200) * 2);
		float y = 0;
		float z = -2;
		
		glTranslatef(x, y, z);
		
		glPushMatrix();
		{
			Graphics.drawCube(0, 0, 0, 1, 1, 1);
		}
		glPopMatrix();
		

		glTranslatef(-x, -y, -z);
	}

	public static void main(String[] args) {
		new Main(1280, 720, "First Engine Test");
	}

}
