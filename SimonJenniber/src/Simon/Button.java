package Simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceJenniber {

	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	private Action action;
	private Color c;
	private Color displayColor;
	private boolean highlight;
	
	public Button() {
		super(0,0,WIDTH,HEIGHT);
	}

	@Override
	public void highlight() {
		

	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ButtonInterfaceJenniber getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
