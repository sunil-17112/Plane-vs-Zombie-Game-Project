package application;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Zombie extends Character{

	ImageView p;
	private int health;
	private final int attack;
	private boolean life_state;
	
	public Zombie(double x,double y,ImageView p,int health,int attack) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.p=p;
		this.health=health;
		this.attack=attack;
		
		
	}
	public int getAttack() {
		return attack;
	}
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean getLife_state() {
		return this.life_state;
	}
	public void setLife_state(boolean life_state) {
		this.life_state = life_state;
	}
	public void move() {
		
	}
	
}
