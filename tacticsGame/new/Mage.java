package com.example.tactical;

public class Mage implements Cell 
{
	private boolean selected = false;
	private final int hitPoint = 0;
	private final int attack = 0;
	
	private int image = R.drawable.grass;
	
	public int getColor()
	{
		return 0;
	}

	public boolean isSelected()
	{
		return selected;
	}


	public void setSelected(Boolean selected)
	{
		this.selected = selected;
	}

	public int getHitPoint()
	{
		return hitPoint;
	}

	public int getAttack()
	{
		return attack;
	}
	
	public int getImage()
	{
		return image;
	}
	
}
