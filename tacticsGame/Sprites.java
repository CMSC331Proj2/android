package tacticsGame;

import java.awt.Image;

import javax.swing.ImageIcon;

public enum Sprites {
	PLACEHOLDER ("Images/Dapper Shark.jpg");
	
	private Image sprite;
	
	Sprites(String address){
		sprite = new ImageIcon(this.getClass().getResource(address)).getImage();
		sprite = sprite.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
	}
	
	Image getSprite(){
		return sprite;
	}
}