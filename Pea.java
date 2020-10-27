package application;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Pea extends Character {
	ImageView p;
	private int attack;
	StackPane pane;
	public Pea(double x,double y,ImageView p,int attack,StackPane pane) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.pane=pane;
		this.p=p;
		this.attack=attack;
		p.setTranslateX(x);
		p.setTranslateY(y);
		pane.getChildren().add(p);
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
}
