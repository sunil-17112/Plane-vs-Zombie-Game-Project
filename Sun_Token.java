package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Sun_Token extends Character{
 
	int val;
	ImageView p;
	ArrayList<Sun_Token> sun;
	StackPane pane;
	Field f;
	public Sun_Token(double x,double y,StackPane pane,ArrayList<Sun_Token> sun,Field f) {
		// TODO Auto-generated constructor stub
		super(x, y);
		this.val=25;
		this.sun=sun;
		this.f=f;

		try {
			this.p=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\sun.png")));
			p.setTranslateX(x);
			p.setTranslateY(y);
			this.pane=pane;
			this.pane.getChildren().add(p);
			p.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent arg0) {
					remove();
				}
			});
		}
		catch(FileNotFoundException e) {
			
		}
	}
	void remove() {
		for(int i=0;i<sun.size();i++) {
			if(sun.get(i)==this) {
				this.pane.getChildren().remove(this.p);
				sun.remove(i);
				this.f.g.score+=this.val;
				
				break;
			}
		}
		System.out.println(sun.size() + " " + this.f.g.score);
	}
	
}
