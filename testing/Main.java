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

	}

	public static void main(String[] args) {
		new Main(1280, 720, "First Engine Test");
	}

}
