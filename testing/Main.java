import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

import java.awt.Polygon;
import java.awt.geom.CubicCurve2D;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.Sphere;
import org.lwjgl.util.vector.Vector3f;

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

	double xx = 0;
	double yy = 0;

	
	@Override
	public void render() {
		delta++;
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		glClearColor(0, 0, 0, 0);
		double Xspeed = 1;
		double Yspeed = 5;

		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yy+=Yspeed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xx+=Xspeed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yy-=Yspeed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xx-=Xspeed;
		}
		System.out.println(xx);
		if (xx < -180) {
			xx = -180;
		}
		if (xx > -0) {
			xx = -0;
		}

		float x = 0;
		float y = -5;
		float z = -20;
		float rx = 20;
		float ry = 0;
		float rz = 0;

		glTranslatef(x, y, z);
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 1, 0);
		glRotatef(rz, 0, 0, 1);

		glPushMatrix();
		{
			glRotated(xx, 0, 1, 0);
			glRotated(yy, 0, 0, 1);

			Graphics.drawCube(new Vector3f(0, 0, 0), new Vector3f(.8f, .8f, .8f));
			Graphics.drawCube(new Vector3f(0, 0, 0), new Vector3f(2.5f, .2f, .2f));
			Graphics.drawCube(new Vector3f(0, 0, 0), new Vector3f(.2f, 2.5f, .2f));
			Graphics.drawCube(new Vector3f(0, 0, 0), new Vector3f(.2f, .2f, 4.5f));
			Graphics.drawCube(new Vector3f(1.5f, 0, 0), new Vector3f(.5f, .5f, .5f));
			Graphics.drawCube(new Vector3f(-1.5f, 0, 0), new Vector3f(.5f, .5f, .5f));
			Graphics.drawCube(new Vector3f(0, 1.5f, 0), new Vector3f(.5f, .5f, .5f));
			Graphics.drawCube(new Vector3f(0, -1.5f, 0), new Vector3f(.5f, .5f, .5f));

		}
		glPopMatrix();

		glPushMatrix();
		{
			glRotated(xx, 0, 1, 0);

			Graphics.drawCube(new Vector3f(0, -1, -2), new Vector3f(1f, 3f, .5f));
			Graphics.drawCube(new Vector3f(0, -1, 2), new Vector3f(1f, 3f, .5f));
			Graphics.drawCube(new Vector3f(0, -2.5f, 0), new Vector3f(5f, .5f, 5f));

		}
		glPopMatrix();

		glTranslatef(-x, -y, -z);
		glRotatef(-rx, 1, 0, 0);
		glRotatef(-ry, 0, 1, 0);
		glRotatef(-rz, 0, 0, 1);
	}

	private void renderSphere(float x, float y, float z) {
		glPushMatrix();
		glTranslatef(x, y, z);
		Sphere s = new Sphere();
		s.draw(0.4f, 16, 16);
		glPopMatrix();
	}

	public static void main(String[] args) {
		new Main(1280, 720, "First Engine Test");
	}

}
