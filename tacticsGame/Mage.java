package androidGame.tacticalrpg;

public class Mage extends Unit {
	
	public Mage(String name, String team, int x, int y) {
		super(name, 4, 4, 15, x, y);
		this.team = team;
		if(this.team.equals("Blue")){
			sprite = R.drawable.blue_mage;
		} else if(this.team.equals("Red")){
			sprite = R.drawable.red_mage;
		}
	}
}
