package com.example.tactical;


public class Archer implements Cell 
{
	private boolean selected = false;
	private String color;
	private final int hitPoint = 20;
	private final int attack = 3;
	private final int range = 4;
	
	private int image;
	
	public Archer(String color)
	{
		this.color = color;
		setImage();
	}
	
	private void setImage()
	{
		if(color.equals("Blue"))
			image = R.drawable.archer_blue;
		if(color.equals("Red"))
			image = R.drawable.archer_red;
	}

	public String getColor()
	{
		return color;
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

	public int getRange()
	{
		return range;
	}
	
}
