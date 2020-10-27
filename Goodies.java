package application;

public class Goodies extends Character{

	private int num_coins;
	private boolean visibility;
	public Goodies(int v,int x,int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.visibility=true;
		this.num_coins=v;
	}
	public int getNum_coins() {
		return num_coins;
	}
	public void setNum_coins(int num_coins) {
		this.num_coins = num_coins;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public void IncInCoins() {
		
	}
}
