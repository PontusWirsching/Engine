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

	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glTranslatef(0, 0, -5);
		
		Graphics.drawCube(0, 0, 0, 1, 1, 1);
		
		glTranslatef(0, 0, 5);

		
	}

	public static void main(String[] args) {
		new Main(1280, 720, "First Engine Test");
	}

}
