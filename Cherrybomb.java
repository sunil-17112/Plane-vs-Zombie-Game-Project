package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cherrybomb extends Plant{

	private int row;
	private int col;
	StackPane pane;
	public Cherrybomb(double x,double y,StackPane pane)throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(x, y, new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Cherry_Bomb1.png"))));
		this.row=3;
		this.col=3;
		this.pane=pane;
		pane.getChildren().add(p);
		p.setTranslateX(x);
		p.setTranslateY(y);
		
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public void blast() {
		
	}
}
