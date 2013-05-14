package androidGame.tacticalrpg;

public class Archer extends Unit {

	public Archer(String name, String team, int x, int y) {
		super(name, 4, 6, 20, x, y);
		this.range = 5;
		this.team = team;
		if(this.team.equals("Blue")){
			sprite = R.drawable.archer_blue;
		} else if(this.team.equals("Red")){
			sprite = R.drawable.archer_red;
		}
	}

}
