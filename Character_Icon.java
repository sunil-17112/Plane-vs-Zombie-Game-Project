package application;

import java.util.ArrayList;

import javafx.scene.layout.StackPane;

abstract class Character_Icon extends Character{

	Field f;
	
	private boolean availability;
	private int life;
	private int timer;
	private final int cost;
	public Character_Icon(double x,double y,boolean a,int t,Field f,int cost) {
		// TODO Auto-generated constructor stub
		super(x, y);
		this.life=t;
		this.f=f;
		this.availability=a;
		this.timer=life;
		this.cost=cost;
	}
	public int getCost() {
		return cost;
	}
	public int getLife() {
		return life;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	public boolean getAvailability() {
		return this.availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public void activate_icon() {
		if(f.g.score>=this.cost) {
			if(timer>=life) {
				this.availability=true;
				
				
			}
			else {
				this.availability=false;
			}
		}
		else {
			this.availability=false;
		}
	}
	
}
