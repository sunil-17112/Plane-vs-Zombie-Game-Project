package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Field {

	boolean prog=false;
	int zomb_cum=20000;
	TextField score_text;
	private static int time;
	Stage field_page;
	StackPane pane;
	Game g;
	int time_shov=0;
	Shovel shov=null;
	ArrayList<Peashooter> peashoot;
	ArrayList<Wallnut> wallnut;
	ArrayList<Cherrybomb> cherrybomb;
	ArrayList<Sunflower> sunflower;
	ArrayList<Zombie> zomb;
	ArrayList<Sun_Token> sun;
	ArrayList<Pea> pea;
	Peashooter_Icon pea_icon;
    Wallnut_Icon wall_icon;
    Sunflower_Icon sun_icon;
    Cherrybomb_Icon cherry_icon;
    Shovel_Icon shov_icon;
    Zombie_bar_Icon zombie_bar_icon;
	private ArrayList<Lawn_Mower>lawnmower;
	
	private final double[] rows= {-400,-250,-100,50,200,350,500,650,800};
	private final double[] col= {-300,-125,50,225,400};
	private boolean[][] lawn;
	
	public Field(Game g) {
		this.g=g;
		this.time=0;
		// TODO Auto-generated constructor stub
		zomb=new ArrayList<Zombie>();
		sun=new ArrayList<Sun_Token>();
		peashoot=new ArrayList<Peashooter>();
		wallnut=new ArrayList<Wallnut>();
		cherrybomb=new ArrayList<Cherrybomb>();
		sunflower=new ArrayList<Sunflower>();
		lawn=new boolean[9][5];
		pea=new ArrayList<Pea>();
		lawnmower=new ArrayList<Lawn_Mower>();
	}
	public void pop_up() {
		try {
			Stage s=new Stage();
			StackPane p=new StackPane();
			Button b=new Button("OK");
			ImageView img;
			if(g.getLevel()==1) {
				img=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\sun_fact.png")));
				p.getChildren().add(img);
			}
			if(g.getLevel()==2) {
				img=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\cherryfact.png")));
				p.getChildren().add(img);
			}
			if(g.getLevel()==3) {
				img=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\wallnutfact.png")));
				p.getChildren().add(img);
			}
			if(g.getLevel()==4) {
				img=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\peafact.png")));
				p.getChildren().add(img);
			}
			
			p.getChildren().add(b);
			b.setTranslateY(200);
			b.setOnAction(e->{
				s.close();
			});
			Scene scene=new Scene(p,500,500);
			s.setScene(scene);
			s.show();
		}
		catch(FileNotFoundException e) {
			
		}
	}
	public double[] getCol() {
		return col;
	}
	public double[] getRows() {
		return rows;
	}
	public boolean[][] getLawn() {
		return lawn;
	}
	public ArrayList<Pea> getPea() {
		return pea;
	}
	public void setupTimeline(){
		KeyFrame kf = new KeyFrame(Duration.millis(1),new TimeHandler());
		Timeline timeline = new Timeline(kf);
		
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private class TimeHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event){
		time++;
		if(time>=20000&&zombie_bar_icon.an.getTranslateX()>500) {
			zombie_bar_icon.p.setVisible(true);
			zombie_bar_icon.an.setVisible(true);
			//System.out.println(zombie_bar_icon.getLife()*1000);
		//	//System.out.println(200/(double)zombie_bar_icon.getLife()*1000);
			
			//zombie_bar_icon.an.setTranslateX(zombie_bar_icon.an.getTranslateX()-(200/((double)zombie_bar_icon.getLife()*1000)));
			zombie_bar_icon.an.setTranslateX(zombie_bar_icon.an.getTranslateX()-0.001);
		}
		if(prog==false&&zombie_bar_icon.an.getTranslateX()<=501&&zomb.size()==0) {
			try {
				prog=true;
				ImageView goodie=new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Goodie.png")));
				/*Label c=new Label(Integer.toString(100*g.getLevel()));
		        c.setFont(new Font("Serif" , 55));
		        c.setStyle("-fx-font-weight : Bold");*/
				pane.getChildren().addAll(goodie);
				goodie.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						goodie.setVisible(false);
						if(g.getLevel()!=5) {
							pop_up();
						}
						g.user.setCoins(100*g.getLevel());
						g.lev.level_but[g.getLevel()].setDisable(false);
						field_page.close();
					}
				});
			}
			catch (FileNotFoundException e) {
				// TODO: handle exception
			}
		}
		
		if(time>=20000&&zombie_bar_icon.an.getTranslateX()>=650) {
			if(zomb_cum%20000==0) {
				add_zombie(random_generation(col));
			}
		}
		if(zombie_bar_icon.an.getTranslateX()<650&&zombie_bar_icon.an.getTranslateX()>=600) {
			if(zomb_cum%10000==0) {
				add_zombie(random_generation(col));
			}
		}
		if(zombie_bar_icon.an.getTranslateX()<600&&zombie_bar_icon.an.getTranslateX()>=550) {
			if(zomb_cum%6000==0) {
				add_zombie(random_generation(col));
			}
		}
		if(zombie_bar_icon.an.getTranslateX()<550&&zombie_bar_icon.an.getTranslateX()>=500) {
			if(zomb_cum%3000==0) {
				add_zombie(random_generation(col));
			}
		}
		if(shov!=null) {
			time_shov++;
		}
		if(time_shov==1000) {
			pane.getChildren().remove(shov);
			shov=null;
			time_shov=0;
		}
		zomb_cum++;
		
		
		//
		score_text.setText(Integer.toString(g.score));
		
		for(int i=0;i<zomb.size();i++) {
			
			zomb.get(i).p.setTranslateX(zomb.get(i).p.getTranslateX()-0.01);
			//pea.get(i).p.setTranslateY(pea.get(i).p.getTranslateY()+100);
			if(zomb.get(i).p.getTranslateX()<-540) {
				//zomb.get(i).p.setTranslateX(zomb.get(i).getX());
				for(int j=0;j<lawnmower.size();j++) {
					if(zomb.get(i).p.getTranslateY()==lawnmower.get(j).getY()) {
						//zomb.get(i).p.setTranslateX(-1000);
						pane.getChildren().remove(zomb.get(i).p);
						zomb.remove(i--);
						lawnmower.get(j).p.setTranslateX(lawnmower.get(j).p.getTranslateX()+0.5);
						break;
					}
					
				}
			}
			
			
		}
		for(int i=0;i<lawnmower.size();i++) {
			if(lawnmower.get(i).p.getTranslateX()!=-540) {
				lawnmower.get(i).p.setTranslateX(lawnmower.get(i).p.getTranslateX()+0.5);
				for(int j=0;j<zomb.size();j++) {
					if(zomb.get(j).p.getTranslateX()<=(lawnmower.get(i).p.getTranslateX()+0.5)&& zomb.get(j).p.getTranslateX()>=(lawnmower.get(i).p.getTranslateX())){
						pane.getChildren().remove(zomb.get(j).p);
						zomb.remove(j);
						break;
					}
				}
		}
		
		}
		
	/// zombie attack	
		for(int i=0;i<zomb.size();i++) {
			double x=zomb.get(i).p.getTranslateX();
			for(int j=0;j<peashoot.size();j++) {
				if(peashoot.get(j).getX()>=x-1&&peashoot.get(j).getX()<=x) {
					peashoot.get(j).setHealth(peashoot.get(j).getHealth()-((double)zomb.get(i).getAttack())/1000);
					zomb.get(i).p.setTranslateX(zomb.get(i).p.getTranslateX()+0.01);
				}
			}
		}
		
		for(int i=0;i<zomb.size();i++) {
			if(zomb.get(i).getHealth()<=0) {
				
				for(int j=0;j<peashoot.size();j++) {
					if(peashoot.get(j).getY()==zomb.get(i).getY()) {
						peashoot.get(j).avail=false;
					}
				}
				pane.getChildren().remove(zomb.get(i).p);
				zomb.remove(i--);
			}
	}
		for(int i=0;i<zomb.size();i++) {
			double x=zomb.get(i).p.getTranslateX();
			for(int j=0;j<sunflower.size();j++) {
				if(sunflower.get(j).getX()>=x-1&&sunflower.get(j).getX()<=x) {
					sunflower.get(j).setHealth(sunflower.get(j).getHealth()-((double)zomb.get(i).getAttack())/1000);
					zomb.get(i).p.setTranslateX(zomb.get(i).p.getTranslateX()+0.01);
				}
			}
		}
		for(int i=0;i<zomb.size();i++) {
			double x=zomb.get(i).p.getTranslateX();
			for(int j=0;j<wallnut.size();j++) {
				if(wallnut.get(j).getX()>=x-1&&wallnut.get(j).getX()<=x) {
					wallnut.get(j).setHealth(wallnut.get(j).getHealth()-((double)zomb.get(i).getAttack())/1000);
					zomb.get(i).p.setTranslateX(zomb.get(i).p.getTranslateX()+0.01);
				}
			}
		}
		//////////////////
		for(int i=0;i<peashoot.size();i++) {
			if(peashoot.get(i).getHealth()<=0) {
				pane.getChildren().remove(peashoot.get(i).p);
				lawn[((int)peashoot.get(i).getX()+400)/150][((int)peashoot.get(i).getY()+300)/175]=false;
				peashoot.remove(i--);
			}
		}
		for(int i=0;i<sunflower.size();i++) {
			if(sunflower.get(i).getHealth()<=0) {
				pane.getChildren().remove(sunflower.get(i).p);
				sunflower.remove(i--);
			}
		}
		for(int i=0;i<wallnut.size();i++) {
			if(wallnut.get(i).getHealth()<=0) {
				pane.getChildren().remove(wallnut.get(i).p);
				wallnut.remove(i--);
			}
		}
		/////////////////
		// Suntoken transition 
		if(time%10000==0) {
			add_suntoken(random_generation(rows),-500);
		}
		for(int i=0;i<sun.size();i++) {
			
			if(sun.get(i).getY()==-500&&sun.get(i).p.getTranslateY()<430) {
				sun.get(i).p.setTranslateY(sun.get(i).p.getTranslateY()+0.05);
			}
		}
		
		//////////////
		
		for(int i=0;i<sunflower.size();i++) {
			sunflower.get(i).timer++;
		}
		for(int i=0;i<sunflower.size();i++) {
			if(sunflower.get(i).timer==10000) {
				sunflower.get(i).sunTokenProduce();
				sunflower.get(i).timer=0;
			}
		}
		
		/////////////
		for(int i=0;i<peashoot.size();i++) {
				if(peashoot.get(i).avail==false) {
				int flag=0;
				for(int j=0;j<zomb.size();j++) {
					if(zomb.get(j).getY()==peashoot.get(i).getY()) {
						peashoot.get(i).avail=true;
						//peashoot.get(i).life=10;
						break;
					}
				}
				}
		}
		for(int i=0;i<peashoot.size();i++) {
			if(peashoot.get(i).avail==true) {
				if(peashoot.get(i).life==2000) {
					peashoot.get(i).pea_produce(pea);
					peashoot.get(i).life=0;						
				}
				else {
					peashoot.get(i).life++;
				}
			}
		}
		
		for(int i=0;i<pea.size();i++) {
			pea.get(i).p.setTranslateX(pea.get(i).p.getTranslateX()+0.3);
			if(pea.get(i).p.getTranslateX()>950) {
				pane.getChildren().remove(pea.get(i).p);
				pea.remove(i--);
			}
			
		}
				
			
		for(int i=0;i<pea.size();i++) {
				
			double x=pea.get(i).p.getTranslateX();
			for(int j=0;j<zomb.size();j++) {
				if(zomb.get(j).getY()==pea.get(i).getY()) {
					if(zomb.get(j).p.getTranslateX()>x-1&&zomb.get(j).p.getTranslateX()<x+1) {
						zomb.get(j).setHealth(zomb.get(j).getHealth()-pea.get(i).getAttack());
						pane.getChildren().remove(pea.get(i).p);
						pea.remove(i--);
						break;
					}
						
				}
			}
				
		}
		if(pea_icon!=null) {
			pea_icon.setTimer(pea_icon.getTimer()+1);
		}
		if(sun_icon!=null) {
			sun_icon.setTimer(sun_icon.getTimer()+1);
		}
		if(wall_icon!=null) {
			wall_icon.setTimer(wall_icon.getTimer()+1);
		}
		if(cherry_icon!=null) {
			cherry_icon.setTimer(cherry_icon.getTimer()+1);
		}
		
		if(pea_icon!=null&&pea_icon.p.isDisable()) {
			if(pea_icon.getTimer()>=pea_icon.getLife()&&g.score>=pea_icon.getCost()) {
				pea_icon.p.setDisable(false);
			}		
		}
		if(sun_icon!=null&&sun_icon.p.isDisable()) {
			if(sun_icon.getTimer()>=sun_icon.getLife()&&g.score>=sun_icon.getCost()) {
				sun_icon.p.setDisable(false);
			}
		}
		if(wall_icon!=null&&wall_icon.p.isDisable()) {
			if(wall_icon.getTimer()>=wall_icon.getLife()&&g.score>=wall_icon.getCost()) {
				wall_icon.p.setDisable(false);
			}
		}
		if(cherry_icon!=null&&cherry_icon.p.isDisable()){
			if(cherry_icon.getTimer()>=cherry_icon.getLife()&&g.score>=cherry_icon.getCost()) {
				cherry_icon.p.setDisable(false);
			}
		}
		
	}
}
	public double random_generation(double[] a) {
		Random r=new Random();
		int i=r.nextInt(a.length);
		return a[i];
	}
	public void add_lawnmower() {
		try {
		   Image l1=new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\lawn_mower.gif"));
		   Image l2=new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\lawn_mower.gif"));
		   Image l3=new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\lawn_mower.gif"));
		   Image l4=new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\lawn_mower.gif"));
		   Image l5=new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\lawn_mower.gif"));
		   
		    ImageView  lawn_mower1=new ImageView(l1);
	        ImageView  lawn_mower2=new ImageView(l2);
	        ImageView  lawn_mower3=new ImageView(l3);
	        ImageView  lawn_mower4=new ImageView(l4);
	        ImageView  lawn_mower5=new ImageView(l5);
	        pane.getChildren().addAll(lawn_mower1,lawn_mower2,lawn_mower3,lawn_mower4,lawn_mower5);
		   	lawn_mower1.setTranslateX(-540);
			lawn_mower1.setTranslateY(-300);
			lawn_mower2.setTranslateX(-540);
			lawn_mower2.setTranslateY(-125);
			lawn_mower3.setTranslateX(-540);
			lawn_mower3.setTranslateY(50);
			lawn_mower4.setTranslateX(-540);
			lawn_mower4.setTranslateY(225);
			lawn_mower5.setTranslateX(-540);
			lawn_mower5.setTranslateY(400);
			lawnmower.add(new Lawn_Mower(lawn_mower1.getTranslateX(),lawn_mower1.getTranslateY(),lawn_mower1));
			lawnmower.add(new Lawn_Mower(lawn_mower2.getTranslateX(),lawn_mower2.getTranslateY(),lawn_mower2));
			lawnmower.add(new Lawn_Mower(lawn_mower3.getTranslateX(),lawn_mower3.getTranslateY(),lawn_mower3));
			lawnmower.add(new Lawn_Mower(lawn_mower4.getTranslateX(),lawn_mower4.getTranslateY(),lawn_mower4));
			lawnmower.add(new Lawn_Mower(lawn_mower5.getTranslateX(),lawn_mower5.getTranslateY(),lawn_mower5));
		}
		catch(FileNotFoundException e) {
			
		}
	}
	
	public void add_zombie(double y) {
		try {
			zomb.add(new Zombie(950, y,new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\zombie.gif"))) ,(100+10*g.getLevel()),(10+g.getLevel())));
			ImageView a=zomb.get(zomb.size()-1).p;
			pane.getChildren().add(a);
			a.setTranslateX(950);
			a.setTranslateY(y);
			//add_suntoken();
		}
		catch(FileNotFoundException e) {
			
		}
			
		
	}
	public void add_suntoken(double x,double y) {
		
			sun.add(new Sun_Token(x,y, pane, sun,this));
			//System.out.println(sun.size());
		
	}
	public void add_plants() {
		
	}
	public void add_plants_icon() {
		 try {
		        /*Button  peashooter_icon=new Button("100",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Peashooter.png"))));
		        Button  sunflower_icon=new Button("50",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Sunflower.png"))));
		        Button  walnut_icon=new Button("50",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Wall-nut.png"))));
		        Button  cherrybomb_icon=new Button("150",new ImageView(new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\Cherry_Bomb1.png"))));
		        */
		        if(this.g.getLevel()==1) {
		        	//System.out.println("sunil");
		        	pea_icon=new Peashooter_Icon(-900, -100, true, this,pane);
		        	
		        	zombie_bar_icon=new Zombie_bar_Icon(600, -480,true,(500+100*g.getLevel()),this,0,pane);
		        	//pane.getChildren().addAll(peashooter_icon);
			        
		        }
		        if(this.g.getLevel()==2) {
		        	pea_icon=new Peashooter_Icon(-900, -100, true, this,pane);
			        sun_icon=new Sunflower_Icon(-900, 100, true, this,pane);
			        zombie_bar_icon=new Zombie_bar_Icon(600, -480,true,(500+100*g.getLevel()),this,0,pane);
			        //pane.getChildren().addAll(peashooter_icon,sunflower_icon;
		        }
		        if(this.g.getLevel()==3) {
		        	pea_icon=new Peashooter_Icon(-900, -100, true, this,pane);
			        sun_icon=new Sunflower_Icon(-900, 100, true, this,pane);
			        cherry_icon=new Cherrybomb_Icon(-900, 200, true, this,pane);
			        zombie_bar_icon=new Zombie_bar_Icon(600, -480,true,(500+100*g.getLevel()),this,0,pane);
			       // pane.getChildren().addAll(peashooter_icon,sunflower_icon,cherrybomb_icon);
		        }
		        if(this.g.getLevel()==4) {
		        	pea_icon=new Peashooter_Icon(-900, -100, true, this,pane);
			        wall_icon=new Wallnut_Icon(-900, 0, true, this,pane);
			        sun_icon=new Sunflower_Icon(-900, 100, true, this,pane);
			        cherry_icon=new Cherrybomb_Icon(-900, 200, true, this,pane);
			        zombie_bar_icon=new Zombie_bar_Icon(600, -480,true,(500+100*g.getLevel()),this,0,pane);
			       // pane.getChildren().addAll(peashooter_icon,sunflower_icon,walnut_icon,cherrybomb_icon);
		        }
		        if(this.g.getLevel()==5) {
		        	pea_icon=new Peashooter_Icon(-900, -100, true, this,pane);
			        //wall_icon=new Wallnut_Icon(-900, 0, true, this,pane);
			        sun_icon=new Sunflower_Icon(-900, 100, true, this,pane);
			        //cherry_icon=new Cherrybomb_Icon(-900, 200, true, this,pane);
			        shov_icon=new Shovel_Icon(0,-400,true,this,pane);
			        zombie_bar_icon=new Zombie_bar_Icon(600, -480,true,(500+100*g.getLevel()),this,0,pane);
			        //pane.getChildren().addAll(peashooter_icon,sunflower_icon,walnut_icon,cherrybomb_icon);
		        }
		        
		       
		
		 }
		 catch(FileNotFoundException e) {
			//System.out.println(e.getMessage());
		 }
	}
	
	
	/*public void enableBlur() {
	    ColorAdjust adj = new ColorAdjust(0, -0.9, -0.5, 0);
	    GaussianBlur blur = new GaussianBlur(5); // 55 is just to show edge effect more clearly.
	    adj.setInput(blur);
	    pane.setEffect(adj);
	}	*/
public void create_page() {
		
		try {
			
			this.field_page=new Stage();
			field_page.setTitle("Field");
			pane=new StackPane();
			
			// create a image 
            Image image1 = new Image(new FileInputStream("C:\\Users\\SUNIL KUMAR\\Desktop\\GUI_Image\\field.png")); 
            
            // create a background image 
            BackgroundImage backgroundimage = new BackgroundImage(image1,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT); 
            // create Background 
            Background background = new Background(backgroundimage); 
            
            Button main_menu=new Button("Main Menu");
            Rectangle rec1 = new Rectangle(100, 50, Color.DARKORANGE);
			rec1.setArcWidth(10);
			rec1.setArcHeight(10);
			main_menu.setShape(rec1);
            main_menu.setStyle("-fx-font-size:30");
            

       
           Label score=new Label("Score");
           score.setFont(new Font("Serif" , 55));
           score.setStyle("-fx-font-weight : Bold");
          
           score_text=new TextField();
		   score_text.setMaxSize(100, 50);
		
          
		   //System.out.println(pane.getLayoutX() + " dw" + pane.getLayoutY());
			
			//VBox box=new VBox();
			//box.getChildren().addAll(peashooter_icon,sunflower_icon,walnut_icon,cherrybomb_icon);
			//box.setAlignment(Pos.CENTER_LEFT);
			//box.setPrefSize(100, 500);
			pane.getChildren().addAll(main_menu,score,score_text);
			
			pane.setBackground(background);
			
			main_menu.setTranslateX(850);
			main_menu.setTranslateY(-460);
			score.setTranslateX(-880);
			score.setTranslateY(-460);
			score_text.setTranslateX(-880);
			score_text.setTranslateY(-400);
			add_lawnmower();
			
			add_plants_icon();
			
			
			/*z.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					z.setVisible(false);
				}
			});*/
			
			
			/*
			sunflower_icon.setOnAction(e->{
				lawnmower.add(new Lawnmower(lawn_mower1.getTranslateX(), lawn_mower1.getTranslateY(), lawn_mower1));
				lawnmower.add(new Lawnmower(lawn_mower2.getTranslateX(), lawn_mower2.getTranslateY(), lawn_mower2));
				lawnmower.add(new Lawnmower(lawn_mower3.getTranslateX(), lawn_mower3.getTranslateY(), lawn_mower3));
				lawnmower.add(new Lawnmower(lawn_mower4.getTranslateX(), lawn_mower4.getTranslateY(), lawn_mower4));
				lawnmower.add(new Lawnmower(lawn_mower5.getTranslateX(), lawn_mower5.getTranslateY(), lawn_mower5));
			});
			
			*/
			/*suntok.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					suntok.setVisible(false);
					suntok.setTranslateY(-500);
				}
			});*/
			main_menu.setOnAction(e->{
				//serialize
				Stage pop=new Stage();
				Button save=new Button("Save the Game");
				Button resume=new Button("Resume");
				Button new_game=new Button("New Game");
				Button exit=new Button("Exit the Game");
				StackPane pane1=new StackPane();
				pane1.getChildren().addAll(save,resume,new_game,exit);
				
				save.setTranslateY(-100);
				resume.setTranslateX(-100);
				new_game.setTranslateX(100);
				exit.setTranslateY(100);
				
				
				exit.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						//empty objectfile
						field_page.close();
						pop.close();
						
					}
				});
				
				save.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
				
						field_page.close();
						pop.close();
					}
				});
				
				new_game.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						//emptyobjectfile
						field_page.close();
						lawn=new boolean[9][5];
						pea=new ArrayList<Pea>();
						create_page();
						pop.close();
					}
				});
				
				resume.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						//deserialize
						pop.close();
					}
				});
				
				Scene scene1=new Scene(pane1,300,300);
				pop.setScene(scene1);
				pop.show();
				
			});
			//field_page.setOpacity(0.8f);
			////
			this.setupTimeline();
			Scene scene=new Scene(pane,1900,1000);
			field_page.setScene(scene);
			field_page.show();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
}
