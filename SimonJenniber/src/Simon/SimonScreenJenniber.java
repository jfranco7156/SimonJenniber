package Simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class SimonScreenJenniber extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceJenniber[] button;
	private ProgressInterfaceJenniber progress;
	private ArrayList<MoveInterfaceJenniber> sequence;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenJenniber(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText(" ");
		nextRound();
	}

	public void nextRound() {
		acceptingInput =false;
		roundNumber ++;
		sequence.add(randomMove());
		//check
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		
		changeText("Simon's Turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceJenniber b = null;
		for(int i=0;i<sequence.size();i++){
			if(b!=null)b.dim();
			
			b = sequence.get(sequenceIndex).getButton();
			b.highlight();
			//10 seconds time
			int sleepTime = 10000/roundNumber;
			if(sleepTime<=0)sleepTime=2;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		b.dim();
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		sequence = new ArrayList<MoveInterfaceJenniber>();
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	public MoveInterfaceJenniber randomMove() {
		ButtonInterfaceJenniber b = null;
		int randNum = (int)(Math.random()*button.length);
		while(randNum==lastSelectedButton){
			randNum = (int)(Math.random()*button.length);
		}
		b = button[randNum];
		lastSelectedButton = randNum;
		return new Move(button[randNum]);
	}


	public ProgressInterfaceJenniber getProgress() {
		return new Progress();
	}

	public void addButtons(ArrayList<Visible> viewObjects) {
		int numOfButtons = 6;
		button = new ButtonInterfaceJenniber[numOfButtons];
		Color[] colors= {Color.blue,Color.red,Color.magenta, Color.yellow, 
				Color.green, Color.orange};
		for(int i= 0; i<numOfButtons; i++){
			button[i] = getAButton();
			button[i].setColor(colors[i]);
			button[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(numOfButtons))));
			button[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(numOfButtons))));
			final ButtonInterfaceJenniber b = button[i];
			System.out.println(b+" has x = "+b.getX()+", y ="+b.getY());
			b.dim();
			b.setAction(new Action(){
				public void act() {
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									b.dim();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						});
						blink.start();
					}
				}
				
			});
			if(acceptingInput && sequence.get(sequenceIndex).getButton() == b){
				sequenceIndex++;
			}else if(acceptingInput){
				progress.gameOver();
				return;
			}
			if(sequenceIndex == sequence.size()){
				Thread nextRound = new Thread(SimonScreenJenniber.this);
				nextRound.start();
			}
			viewObjects.add(button[i]);
		}
		
	}

	private ButtonInterfaceJenniber getAButton() {
		return new Button();
	}

}