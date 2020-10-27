package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Shovel extends Character{

	ImageView p;
	StackPane pane;
	public Shovel(double x,double y,StackPane pane) throws FileNotFoundException{
		// TODO Auto-generated constructor stub
		super(x, y);
		this.p=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Shovel.png")));
		this.pane=pane;
		pane.getChildren().add(p);
		
	}
	
}
