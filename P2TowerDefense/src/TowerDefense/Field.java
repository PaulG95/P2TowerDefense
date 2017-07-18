package TowerDefense;

import java.awt.Rectangle;

/**
 * This class represents one Field of the Game.
 * It has an Position and can be occupied.
 * The Game-Field is a grid, built with many Fields.
 * @author Bettina
 *
 */
public class Field 
{
	private Rectangle field;
	private boolean occupied;

	private boolean lastPath;
	private boolean _isPath;
	private Object occupier;

	private int  xPos,yPos;	
	/**
	 * A Field is created with an x and a y value
	 * @param xPos defines the position on the x-axis
	 * @param yPos defines the position on the y-axis
	 */
	public Field(int xPos, int yPos)
	{
		occupied = false;
		_isPath = false;
		this.xPos = xPos;
		this.yPos = yPos;
		field = new Rectangle(xPos,yPos,Values.FIELD_SIZE,Values.FIELD_SIZE);
	}
	
	public Rectangle getField(){
		return field;
	}
	
	/**
	 * @return Returns this Field's position on the x-Axis
	 */
	public int getXPos() 
	{
		return xPos;
	}

	/**
	 * @return Returns this Field's position on the y-Axis
	 */
	public int getYPos() 
	{
		return yPos;
	}

	/**
	 * @return Returns true if this Field is occupied
	 */
	public boolean isOccupied() 
	{
		return occupied;
	}
	
	/**
	 * sets this Field's status to occupied
	 */
	public void setOccupied(Object o) 
	{
		this.occupier = o;
		this.occupied = true;
	}
	
	public boolean isPath() {
		return _isPath;
	}
	
	public void setPath(boolean _isPath) {
		this._isPath = isPath();
	}
	
	public boolean isLastPath() {
		return lastPath;
	}
	
	public void setLastPath(boolean lastPath) {
		this.lastPath = lastPath;
	}
	public Object getOccupier() {
		return occupier;

	}
}
