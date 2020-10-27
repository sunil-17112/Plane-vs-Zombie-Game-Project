package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Zombie_bar_Icon extends Character_Icon {

	StackPane pane;
	ImageView p;
	ImageView an;
	public Zombie_bar_Icon(double x,double y,boolean a,int t,Field f,int cost,StackPane pane)throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(x, y, a, t, f, cost);
		this.pane=pane;
		this.p=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\JavaProgressBar.png")));
		pane.getChildren().add(p);
		this.an=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\circularface.png")));
		pane.getChildren().add(an);
		p.setTranslateX(x);
		p.setTranslateY(y);
		an.setTranslateX(700);
		an.setTranslateY(-480);
		p.setVisible(false);
		p.setVisible(false);
	}
	public void generate_zombies() {
		
	}
	public void generate_goddies() {
		
	}

}
