package application;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application implements Serializable{
	private static int flag=0;
	private ArrayList<User> user;
	private Stage main;
	private StackPane pane;
	private Scene scene;
	private ComboBox<String> mycombobox;
	private Button exit;
	private Button ok;
	private Stage s;
	
	
	/*public void serialize()throws IOException,ClassNotFoundException{
		
		Scanner sc=new Scanner(System.in);
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream (
			new FileOutputStream("C:\\Users\\SUNIL KUMAR\\eclipse-workspace\\practice\\src\\practice\\in.txt"));
			out.writeObject(this);	
		} 
		finally {
			out.close();
		}
	}*/
	

	/*public static void deserialize(String str)throws IOException, ClassNotFoundException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (
			new FileInputStream("C:\\Users\\SUNIL KUMAR\\eclipse-workspace\\practice\\src\\practice\\out.txt"));
			
		}
		
		finally {
			in.close();
		}
		
	}
	*/
	public void delete_user(String name) {
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getName().equals(name)) {
				user.remove(i);
				mycombobox.getItems().remove(name);
			}
		}
	}
	public void create_combo() {
		/*pane.getChildren().remove(mycombobox);
		mycombobox=new ComboBox<String>();
		mycombobox.getItems().add("Create User");         
		mycombobox.setStyle("-fx-font-size: 42;");       
	    mycombobox.setPromptText("Select User");*/          
	    
		for(int i=0;i<user.size();i++) {
			if(!mycombobox.getItems().contains(user.get(i).getName())) {
				mycombobox.getItems().add(user.get(i).getName());
			}
			
		}
		
		
	}
	public void create_pop_window_for_create_user(ComboBox<String> c){
		try {
			Stage pop_up=new Stage();
			Button ok=new Button("OK");
			Button cancel=new Button("cancel");
			pop_up.setTitle("create user");
			Label l=new Label();
			l.setText("Enter Name");
			TextField text=new TextField();
			text.setMaxSize(180, 30);
			//text.setText("Enter Name");
			l.setTranslateY(-30);
			
			StackPane pane=new StackPane();
			pane.getChildren().addAll(ok,cancel,text,l);
			ok.setTranslateY(50);
			cancel.setTranslateY(100);
			ok.setOnAction(e->{
				String name=text.getText();
				//System.out.println(name);
				user.add(new User(name,this));
				create_combo();
				mycombobox.setValue("Select User");
				pop_up.close();
			});
			cancel.setOnAction(e->{
				mycombobox.setValue("Select User");
				pop_up.close();
			});
			
			Scene scene=new Scene(pane,300,300);
			pop_up.setScene(scene);
			pop_up.show();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setupTimeline(){
		KeyFrame kf = new KeyFrame(Duration.millis(5000),new TimeHandler());
		Timeline timeline = new Timeline(kf);
		
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	private class TimeHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event){
			
			try {
					if(flag==0) {
						main=new Stage();
						user=new ArrayList<User>();
						mycombobox=new ComboBox<String>();
						mycombobox.getItems().add("Create User");
						mycombobox.setStyle("-fx-font-size: 42;");
					    mycombobox.setPromptText("Select User");
						exit=new Button("",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\circle-cropped.png"))));
						Circle circle1 = new Circle(20, Color.YELLOW);
			        	circle1.setStroke(Color.YELLOW);
			        	exit.setShape(circle1);
						ok=new Button("",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\bkk.png"))));
						Circle circle2 = new Circle(100, Color.PINK);
			        	circle2.setStroke(Color.PINK);
			        	ok.setShape(circle2);
						pane=new StackPane();
						scene=new Scene(pane,1900,1000);
						 // create a image 
			            Image image1 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\cover2.jpg")); 
			  
			            // create a background image 
			            BackgroundImage backgroundimage = new BackgroundImage(image1,  
			                                             BackgroundRepeat.NO_REPEAT,  
			                                             BackgroundRepeat.NO_REPEAT,  
			                                             BackgroundPosition.DEFAULT,  
			                                                BackgroundSize.DEFAULT); 
			            // create Background 
			            Background background = new Background(backgroundimage); 
						pane.getChildren().addAll(exit,ok,mycombobox);
						pane.setBackground(background);
						ok.setVisible(false);
						mycombobox.setTranslateY(-400);
						
						
						mycombobox.setOnAction(e->{
					          
			            	try {
					           String name=mycombobox.getValue();
							    	//System.out.println(name);
					           if(name.toUpperCase().equals("CREATE USER")) {
					        	   ok.setVisible(false);
					        	   create_pop_window_for_create_user(mycombobox);
					        	   
					        	  // myComboBox.isDisabled();
					           }
					           else {
					        	   ok.setVisible(true);
						           ok.setTranslateX(780);
						           ok.setTranslateY(350);
						           ok.setOnAction(new EventHandler<ActionEvent>() {
									
									@Override
									public void handle(ActionEvent event) {
										// TODO Auto-generated method stub
										for(int i=0;i<user.size();i++) {
											if(user.get(i).getName().equals(name)) {
												user.get(i).create_pop_window_for_go_to_userprofile(mycombobox);
												break;
											}
										}
										mycombobox.setValue("Select User");
						            	
										 ok.setVisible(false);
									}
						         });
					           }
			            	}
			            	catch(IndexOutOfBoundsException e1) {
			            		
			            	}
			            	catch(NullPointerException e1) {
			            		
			            	}
			            });
			            mycombobox.setValue(null);
			            exit.setOnAction(e->{
			            	main.close();
			            });
						
						main.setScene(scene);
						main.show();
						flag=1;
						s.close();
					}
			}
			catch(FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			s=primaryStage;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1900,1000);
			 // create a image 
            Image image1 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\coverpagePVZ.jpg")); 
  
            // create a background image 
            BackgroundImage backgroundimage = new BackgroundImage(image1,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundRepeat.NO_REPEAT,  
                                             BackgroundPosition.DEFAULT,  
                                                BackgroundSize.DEFAULT); 
            // create Background 
            Background background = new Background(backgroundimage);
            root.setBackground(background);
			setupTimeline();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
