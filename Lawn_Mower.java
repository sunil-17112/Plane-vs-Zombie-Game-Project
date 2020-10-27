package application;

import javafx.scene.image.ImageView;

public class Lawn_Mower extends Character{

	ImageView p;
	private boolean availability;
	public Lawn_Mower(double x,double y,ImageView p) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.p=p;
		this.availability=true;
	}
	public void roll() {
		
	}
	public boolean getAvailability() {
		return this.availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
