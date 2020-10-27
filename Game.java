package application;

public class Game {

	level lev;
	private Field f;
	User user;
	int score;
	private int level;
	public Game(int i,User u,level l) {
		// TODO Auto-generated constructor stub
		this.score=50;
		this.level=i+1;
		this.user=u;
		this.lev=l;
		this.f=new Field(this);
		
		
	}
	public int getLevel() {
		return level;
	}
	public void start() {
		this.f=new Field(this);
		this.f.create_page();
		System.out.println(score);
	}
}
