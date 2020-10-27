package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.sun.javafx.collections.SetAdapterChange;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Peashooter_Icon extends Character_Icon{
 
	
	Button p;
	StackPane pane;
	public Peashooter_Icon(int x,int y,boolean a,Field f,StackPane pane) throws FileNotFoundException{
		// TODO Auto-generated constructor stub
		
		super(x, y,a,10000,f,100);
		this.pane=pane;
		this.p=new Button("100",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Peashooter.png"))));
		p.setDisable(true);
		pane.getChildren().add(p);
		p.setTranslateX(x);
		p.setTranslateY(y);
		p.setOnAction(e->{
				
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
							f.g.score-=100;
							generate_Peashooter(x, y, pane,f.peashoot);
							
								/////////
								flag=1;
						}
						
					}
				});
			});
		
	}
	
	public void generate_Peashooter(double x,double y,StackPane pane,ArrayList<Peashooter> arr) {
		try {
			for(int i=0;i<f.getRows().length;i++) {
				for(int j=0;j<f.getCol().length;j++) {
					if((x<f.getRows()[i]+75&&x>=f.getRows()[i]-75)&&(y<f.getCol()[j]+87.5&&y>=f.getCol()[j]-87.5)) {
						if(f.getLawn()[i][j]==false) {
							arr.add(new Peashooter(f.getRows()[i], f.getCol()[j], 10,100,pane));
						
							/*ImageView peashooter=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Peashoot.gif")));
							pane.getChildren().add(peashooter);
							peashooter.setTranslateX();
							peashooter.setTranslateY();*/
							f.getLawn()[i][j]=true;
							/*
							
							f.getPea().add(new Pea(f.getRows()[i]+25,f.getCol()[j]-17,new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Pea.png"))),0));
							//pane.getChildren().add(pea);
						//	pea.setTranslateX(rows[i]);
							//pea.setTranslateY(col[j]);
							
							pane.getChildren().add(f.getPea().get(f.getPea().size()-1).p);*/
						}
					}
				}
			}
			
		}
		catch(FileNotFoundException e) {
			
		}
	}
}
