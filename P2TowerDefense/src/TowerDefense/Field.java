package TowerDefense;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Field 
{
	private boolean occupied;
	private int  xPos,yPos;	

	public Field(int xPos, int yPos)
	{
		occupied = false;	
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public int getXPos() 
	{
		return xPos;
	}

	public int getYPos() 
	{
		return yPos;
	}

	public boolean isOccupied() 
	{
		return occupied;
	}
	
	public void setOccupied() 
	{
		this.occupied = true;
	}
}
