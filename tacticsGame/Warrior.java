package androidGame.tacticalrpg;

public class Warrior extends Unit {

	public Warrior(String name, String team, int x, int y) {
		super(name, 4, 7, 30, x, y);
		this.team = team;
		if(this.team.equals("Blue")){
			sprite = R.drawable.blue_knight;
		} else if(this.team.equals("Red")){
			sprite = R.drawable.red_knight;
		}
	}

}
