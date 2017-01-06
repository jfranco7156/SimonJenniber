package Simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceJenniber {

	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public ButtonInterfaceJenniber getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
