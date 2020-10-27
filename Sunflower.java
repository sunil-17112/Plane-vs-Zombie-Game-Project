package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Sunflower extends Plant{

	
	Field f;
	int timer;
	private double health;
	public Sunflower(double x,double y,int health,StackPane pane,Field f)throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(x, y,new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\sunflower.gif"))));
		this.timer=0;
		this.p=p;
		this.f=f;
		this.health=health;
		p.setTranslateX(x);
		p.setTranslateY(y);
		pane.getChildren().add(p);
	}
	public void sunTokenProduce() {
		f.add_suntoken(getX(),getY());
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
}
