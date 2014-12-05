import static org.lwjgl.opengl.GL11.*;

import com.core.Engine;


public class Main extends Engine {

	public Main(int width, int height, String title) {
		super(width, height, title);
		
		start();
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glBegin(GL_QUADS);
		{
			glColor3d(1, 1, 1);
			glVertex2i(50, 50);
			glVertex2i(100, 50);
			glVertex2i(100, 100);
			glVertex2i(50, 100);
			
		}
		glEnd();
		
	}

	public static void main(String[] args) {
		new Main(1280, 720, "First Engine Test");
	}

}
