package com.example.tactical;


public class Mage implements Cell 
{
	private boolean selected = false;
	private String color;
	private final int hitPoint = 30;
	private final int attack = 7;
	private final int range = 5;
	
	private int image;
	
	public Mage(String color)
	{
		this.color = color;
		setImage();
	}
	
	private void setImage()
	{
		if(color.equals("Blue"))
			image = R.drawable.mage_blue;
		if(color.equals("Red"))
			image = R.drawable.mage_red;
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
