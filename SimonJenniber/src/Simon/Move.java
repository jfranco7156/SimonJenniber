package Simon;

public class Move implements MoveInterfaceJenniber {

	private ButtonInterfaceJenniber b;
	
	public Move(ButtonInterfaceJenniber b){
		this.b = b;
	}
	
	@Override
	public ButtonInterfaceJenniber getButton() {
		return b;
	}

}
