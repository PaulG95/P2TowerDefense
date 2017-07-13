package TowerDefense;

import java.awt.Dimension;

import javax.swing.JPanel;
/**
 * This class represents one Field of the Game.
 * It has an Position and can be occupied.
 * The Game-Field is a grid, built with many Fields.
 * @author Bettina
 *
 */
public class Field 
{
	private boolean occupied;
	private int  xPos,yPos;	
	/**
	 * A Field is created with an x and a y value
	 * @param xPos defines the position on the x-axis
	 * @param yPos defines the position on the y-axis
	 */
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
