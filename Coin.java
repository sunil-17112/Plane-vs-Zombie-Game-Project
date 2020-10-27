package application;

public class Coin extends Character {

	private int life_span;
	private int val;
	private boolean visibility;
	
	public Coin(int v,int l,int x,int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.visibility=true;
		this.val=v;
		this.life_span=l;
	}
	
	public int getLife_span() {
		return life_span;
	}
	public int getVal() {
		return val;
	}
	public void setLife_span(int life_span) {
		this.life_span = life_span;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public void IncToCoins() {
		
	}
}
