package androidGame.tacticalrpg;

public class Warrior extends Unit {

	public Warrior(String name, String team, int x, int y) {
		super(name, 4, 7, 30, x, y);
		this.team = team;
		if(this.team.equals("Blue")){
			sprite = R.drawable.knight_blue;
		} else if(this.team.equals("Red")){
			sprite = R.drawable.knight_red;
		}
	}

}
