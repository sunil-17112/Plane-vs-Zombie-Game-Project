package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Wallnut extends Plant{

	private  double health;
	StackPane pane;
	
	public Wallnut(double x,double y,int health,StackPane pane) throws FileNotFoundException{
		// TODO Auto-generated constructor stub
		super(x, y, new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Wall-nut.png"))));
		this.health=health;
		this.pane=pane;
		pane.getChildren().add(p);
		p.setTranslateX(x);;
		p.setTranslateY(y);
		
		
		
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
}
