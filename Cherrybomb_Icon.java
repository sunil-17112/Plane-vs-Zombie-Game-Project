package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cherrybomb_Icon extends Character_Icon{

 
	Button p;
	StackPane pane;
	public Cherrybomb_Icon(double x,double y,boolean a,Field f,StackPane pane)throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		super(x, y,a,40000,f,150);
		this.p=new Button("",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Cherry_Bomb1.png"))));
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
						//System.out.println(pea_icon);
						p.setDisable(true);
						setAvailability(false);
						setTimer(0);
						f.g.score-=150;
						generate_cherrybomb(x,y,pane,f.cherrybomb);
						
							/////////
							flag=1;
					}
					
				}
			});
		});
		
	}
	
	public void generate_cherrybomb(double x,double y,StackPane pane,ArrayList<Cherrybomb> arr) {
		try {
			for(int i=0;i<f.getRows().length;i++) {
				for(int j=0;j<f.getCol().length;j++) {
					if((x<f.getRows()[i]+75&&x>=f.getRows()[i]-75)&&(y<f.getCol()[j]+87.5&&y>=f.getCol()[j]-87.5)) {
						if(f.getLawn()[i][j]==false) {
							arr.add(new Cherrybomb(f.getRows()[i], f.getCol()[j],pane));
						
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
