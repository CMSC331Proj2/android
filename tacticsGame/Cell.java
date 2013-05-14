package androidGame.tacticalrpg;

public interface Cell
{

	// returns 0 = null, 1 = red, 2 = blue
	public int getColor();
	
	public boolean isSelected();
	
	public int getHitPoint();

	public int getImage();
	
	public int getAttack();
	
}
