package application;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class User {

	level lev;
	private Main m;
	private String name;
	private int Zombie_Killed;
	private int Coins;
	private Stage profile;
	private StackPane pane;
	ComboBox<String> myComboBox;
	public User(String name,Main m) {
		// TODO Auto-generated constructor stub
		this.lev=new level(this);
		this.m=m;
		this.name=name;
		this.Zombie_Killed=0;
		this.Coins=0;
		this.profile=new Stage();
		this.pane=new StackPane();
		this.myComboBox=new ComboBox<String>();
		myComboBox.getItems().add("Rename");
        myComboBox.getItems().add("delete");
        myComboBox.setStyle("-fx-font-size: 42;");
        myComboBox.setPromptText("Settings");
		
	}
	public String getName() {
		return name;
	}
	public int getZombie_Killed() {
		return Zombie_Killed;
	}
	public int getCoins() {
		return Coins;
	}
	public void setCoins(int coins) {
		Coins = coins;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setZombie_Killed(int zombie_Killed) {
		Zombie_Killed = zombie_Killed;
	}
	
	public void create_pop_window_for_go_to_userprofile(ComboBox<String> c) {
		try {
			this.profile=new Stage();
			 // create a image 
            Image image1 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\image.jpg")); 
  
            // create a background image 
            BackgroundImage backgroundimage = new BackgroundImage(image1,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundPosition.DEFAULT,  
                                                BackgroundSize.DEFAULT); 
            // create Background 
            Background background = new Background(backgroundimage); 
			Text text=new Text(this.getName());
			
			Image image3 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\play2.png"));
        	Button start=new Button("",new ImageView(image3));
			Circle circle3 = new Circle(20, Color.YELLOW);
        	circle3.setStroke(Color.YELLOW);
        	start.setShape(circle3);
        	
        	Button achievement=new Button("Achievements");
		    Rectangle rec1 = new Rectangle(100, 50, Color.DARKORANGE);
			rec1.setArcWidth(10);
			rec1.setArcHeight(10);
			achievement.setShape(rec1);
		    
			Image image4 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\back.png"));
        	Button back=new Button("",new ImageView(image4));
        	Circle circle1 = new Circle(20, Color.YELLOW);
        	circle1.setStroke(Color.YELLOW);
        	back.setShape(circle1);
        	
        	//back.setStyle("-fx-border-radius: 5;"+
            		
              //      "-fx-min-width: 5px; " +
                //    "-fx-min-height: 5px; " +
                  //  //"-fx-max-width: 5px; " +
                   // "-fx-max-height: 5px;");
        	
		 
		    pane.setBackground(background);
		    pane.getChildren().addAll(start,myComboBox,back,achievement,text);
		    text.setStyle("-fx-font-size:70;");
		    achievement.setStyle("-fx-font-size:40;");
		    Scene scene=new Scene(pane,1900,1000);
		    text.setTranslateY(-450);
		    text.setTranslateX(-30);
		    start.setTranslateX  (780);
		    start.setTranslateY(350);
		    back.setTranslateX(-780);
		    back.setTranslateY(350);
		    achievement.setTranslateY(150);
		    achievement.setTranslateX(-30);
		    myComboBox.setTranslateY(250);
		    myComboBox.setTranslateX(-30);
		    
		    start.setOnAction(e->{
		    	//level=new level_page(); // most dangerous line 
		    	//level.create_page();
		    	this.lev.create_page();
		    	
		    });
		    myComboBox.setOnAction(e->{
		    	String setting=myComboBox.getValue();
		    	if(setting.equals("Rename")) {
		    		
		    		Stage pop_up=new Stage();
					Button ok=new Button("OK");
					Button cancel=new Button("cancel");
					pop_up.setTitle("create user");
					Label l=new Label();
					l.setText("Enter New Name");
					TextField text1=new TextField();
					text1.setMaxSize(180, 30);
					l.setTranslateY(-30);
					StackPane pane1=new StackPane();
					pane1.getChildren().addAll(ok,cancel,text1,l);
					ok.setTranslateY(50);
					cancel.setTranslateY(100);
					Scene scene1=new Scene(pane1,300,300);
					
					ok.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							setName(text1.getText());
							text.setText(getName());
							m.create_combo();
							pop_up.close();
							}
							
						
					});
					cancel.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							pop_up.close();
							
						}
					});
					pop_up.setScene(scene1);
					pop_up.show();
					
		    	}
		    	else {
		    		Stage pop_up=new Stage();
					Button ok=new Button("OK");
					Button cancel=new Button("Cancel");
					pop_up.setTitle("Delete User");
					Text text1=new Text("Are you sure you want to delete the user?");
					StackPane pane1=new StackPane();
					pane1.getChildren().addAll(ok,cancel,text1);
					ok.setTranslateY(50);
					cancel.setTranslateY(100);
					Scene scene1=new Scene(pane1,350,300);
					ok.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
						
							profile.close();
							m.delete_user(text.getText());
							m.create_combo();
							pop_up.close();
							
						}
					});
					cancel.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							pop_up.close();
							
						}
					});
					pop_up.setScene(scene1);
					pop_up.show();
		    	}
		    });
		    
		    back.setOnAction(e->{
		    	profile.close();
		    });
		    
		    achievement.setOnAction(e->{
		    	Stage achieve=new Stage();
		    	achieve.setTitle("Achievements");
		    	Button cancel=new Button("Close");
		    	cancel.setTranslateX(0);
		   		cancel.setTranslateY(40);
	 			achievement.isDisabled();
		    			
	 			VBox box=new VBox();
		    	box.setStyle("-fx-font-size:20");
		   		box.setSpacing(10);
	 			Text Zombies_killed=new Text("Zombies Killed : " + this.getZombie_Killed());
		    	Text Coins=new Text("Coins : " + this.getCoins());
		    	box.setAlignment(Pos.CENTER);
		    	Coins.setX(130);
		   		Coins.setY(-30);
		    	box.getChildren().addAll(Zombies_killed,Coins,cancel);
		    	Scene scene1=new Scene(box,300,300);
		    	cancel.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					achieve.close();
								
					}
				});
		    	achieve.setScene(scene1);
		    	achieve.show();
		    		
		    	
		    });
		    
		    profile.setScene(scene);
		    profile.show();
		    
		    
		    
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
