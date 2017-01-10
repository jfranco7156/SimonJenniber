package Simon; 

import guiPractice.GUIApplication;

public class SimonGameJenniber extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4297926260023939521L;

	public SimonGameJenniber() {
		super();
	}

	@Override
	public void initScreen() {
		SimonScreenJenniber click = new SimonScreenJenniber(getWidth(),getHeight());
		setScreen(click);

	}

	public static void main(String[] args) {
		SimonGameJenniber game = new SimonGameJenniber();
		Thread app = new Thread(game);
		app.start();
	}

}
