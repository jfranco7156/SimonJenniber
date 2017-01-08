package Simon;

import java.awt.Color;

import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceJenniber extends Clickable {
	
	void setColor(Color color);
	
	ButtonInterfaceJenniber getAButton();

	void setX(int i);

	void setY(int i);
	
	void highlight();

	void dim();

	void setAction(Action action);

}
