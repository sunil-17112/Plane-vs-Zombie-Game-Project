package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Shovel_Icon extends Character_Icon {

	StackPane pane;
	Button p;
	public Shovel_Icon(double x,double y, boolean a, Field f,StackPane pane)throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(x, y, a,600, f,0);
		this.pane=pane;
		this.p=new Button("",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\ShovelIcon.png"))));
		pane.getChildren().add(p);
	}
	
	public void generate_shovel(double x,double y) {
		this.p.setOnAction(e->{
			pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
				int flag=0;
				@Override
				public void handle(MouseEvent event) {
					try {
						for(int i=0;i<f.getRows().length;i++) {
							for(int j=0;j<f.getCol().length;j++) {
								if((x<f.getRows()[i]+75&&x>=f.getRows()[i]-75)&&(y<f.getCol()[j]+87.5&&y>=f.getCol()[j]-87.5)) {
									f.shov=new Shovel(f.getRows()[i], f.getCol()[j], pane);
									
								}
							}
						}
						
					}
					catch(Exception e) {
						
					}
				}
		});
		});
	}
		
	
}
