package application;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Sunflower_Icon extends Character_Icon{

	Button p;
	StackPane pane;
	public Sunflower_Icon(double x,double y,boolean a,Field f,StackPane pane) throws FileNotFoundException{
		// TODO Auto-generated constructor stub
		super(x, y,a,5000,f,50);
		this.p=new Button("50",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Sunflower.png"))));
		p.setDisable(true);
		this.pane=pane;
		pane.getChildren().add(p);
		
		p.setTranslateX(x);
		p.setTranslateY(y);
		p.setOnAction(e ->{
			pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
				int flag=0;
				@Override
				public void handle(MouseEvent event) {
					double x=event.getSceneX()-950;
					double y=event.getSceneY()-500;
					if(flag==0) {
							////////
						p.setDisable(true);
						setAvailability(false);
						setTimer(0);
						f.g.score-=50;
						generate_sunflower(x,y,pane,f.sunflower,f);
							/////////
							flag=1;
					}
					
				}
			});
		});
		
		
	}

	public void generate_sunflower(double x,double y,StackPane pane,ArrayList<Sunflower> arr,Field f) {
		try {
			for(int i=0;i<f.getRows().length;i++) {
				for(int j=0;j<f.getCol().length;j++) {
					if((x<f.getRows()[i]+75&&x>=f.getRows()[i]-75)&&(y<f.getCol()[j]+87.5&&y>=f.getCol()[j]-87.5)) {
						if(f.getLawn()[i][j]==false) {
							arr.add(new Sunflower(f.getRows()[i], f.getCol()[j], 100,pane,f));
						
							/*ImageView peashooter=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Peashoot.gif")));
							pane.getChildren().add(peashooter);
							peashooter.setTranslateX();
							peashooter.setTranslateY();*/
							f.add_zombie(f.getCol()[j]);
							f.getLawn()[i][j]=true;
							
						}
					}
				}
			}
			
		}
		catch(FileNotFoundException e) {
			
		}
	}
}
