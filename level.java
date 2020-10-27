package application;

import java.io.FileInputStream;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class level {

	Button[] level_but=new Button[5];
	Game[] game;
	User u;
	public level(User u) {
		// TODO Auto-generated constructor stub
		this.u=u;
		this.game=new Game[5];
		this.game[0]=null;
		this.game[1]=null;
		this.game[2]=null;
		this.game[3]=null;
		this.game[4]=null;
	}
	
	public void pop_up(int l,String t) {
		Stage pop=new Stage();
		Button resume=new Button("Resume");
		Button new_game=new Button("New Game");
		Button close=new Button("close");
		Text text=new Text(t);
		
		StackPane pane=new StackPane();
		pane.getChildren().addAll(resume,new_game,close,text);
		
		text.setTranslateY(-50);
		close.setTranslateY(50);
		resume.setTranslateX(-100);
		new_game.setTranslateX(100);
		resume.setDisable(true);
		
		close.setOnAction(e->{
			pop.close();
		});
		
		resume.setOnAction(e->{
			
		});
		
		new_game.setOnAction(e->{
			game[l-1]=new Game(l-1, u,this);
			game[l-1].start();
			pop.close();
		});
		Scene scene=new Scene(pane,500,300);
		pop.setScene(scene);
		pop.show();
		
	}
	
	public void create_page() {
		try {
			Stage level=new Stage();
			 // create a image 
			
	        Image image1 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\level_back.jpeg")); 
	
	        // create a background image 
	        BackgroundImage backgroundimage = new BackgroundImage(image1,  
	                                         BackgroundRepeat.NO_REPEAT,  
	                                         BackgroundRepeat.NO_REPEAT,  
	                                         BackgroundPosition.DEFAULT,  
	                                            BackgroundSize.DEFAULT); 
	        // create Background 
	        Background background = new Background(backgroundimage);
			HBox box=new HBox();
			box.setPrefSize(1900,700);
			box.setAlignment(Pos.CENTER);
			box.setSpacing(100);
			level.setTitle("Level");
			
			Image image3 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\back.png"));
        	Button back=new Button("",new ImageView(image3));
			Circle circle1 = new Circle(20, Color.YELLOW);
        	circle1.setStroke(Color.YELLOW);
        	back.setShape(circle1);
        	
			
			
			StackPane pane=new StackPane();
			pane.setBackground(background);
			pane.getChildren().add(box);
			pane.getChildren().add(back);
			
			
			for(int i=0;i<5;i++) {
				level_but[i]=new Button("",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\level"+(i+1)+".jpg"))));
				box.getChildren().add(level_but[i]);
				level_but[i].setPrefSize(250, 250);
				
				if(i!=0) {
					level_but[i].setDisable(true);
				}
			}
			
		
			back.setTranslateX(-780);
			back.setTranslateY(350);
			
			
			Scene scene=new Scene(pane,1900,1000);
			
			
			back.setOnAction(e->{
				level.close();
			});
			level_but[0].setOnAction(e->{
				pop_up(1, "You don't have any saved game, Click New Game");
				
				
			});
			level_but[1].setOnAction(e->{
				pop_up(2, "You don't have any saved game, Click New Game");
			});
			level_but[2].setOnAction(e->{
				pop_up(3, "You don't have any saved game, Click New Game");
			});
			level_but[3].setOnAction(e->{
				pop_up(4, "You don't have any saved game, Click New Game");
			});
			level_but[4].setOnAction(e->{
				pop_up(5, "You don't have any saved game, Click New Game");
			});
			
			level.setScene(scene);
			level.show();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
