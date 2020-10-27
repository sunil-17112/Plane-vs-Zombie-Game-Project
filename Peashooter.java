package application;

import java.awt.Button;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Peashooter extends Plant{

	private double health;
	private final int attack;
	StackPane pane;
	int life;
	boolean avail;
	public Peashooter(double x,double y,int attack,int health ,StackPane pane )throws  FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(x, y,new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Peashoot.gif"))));
		this.pane=pane;
		this.health=health;
		this.attack=attack;
		this.life=1000;
		this.avail=false;
		pane.getChildren().add(p);
		p.setTranslateX(x);
		p.setTranslateY(y);
	}
	
	public int getAttack() {
		return attack;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public void pea_produce(ArrayList<Pea> pea) {
		try {
			ImageView  p=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\pea.png")));
			pea.add(new Pea(getX(), getY(), p, attack,pane));
			
		}
		catch(FileNotFoundException e) {
			
		}
	}
}
