package TowerDefense;

import java.awt.Rectangle;
/**
 * This class represents an Enemy with main attributes like
 * hitpoints, size, and a position.
 * @author Bettina
 *
 */
public class Enemy 
{
	private	Rectangle enemy;
	
	private int hitpoints;
	private int x,y;
	private int xPos,yPos;
	private int size;
	private Field field[][];
	/**
	 * An enemy is created with an instance of the gameField
	 * @param field
	 */
	public Enemy(Field[][] field)
	{
		this.field = field;
	
		hitpoints = 20;
		size = 10;
		
		x = Values.ENEMY_START_X;				//Position im Raster
		y = Values.ENEMY_START_Y;
		
		xPos = field[x][y].getXPos();				//Tats�chliche Koordinaten
		yPos = field[x][y].getYPos();
		
		enemy = new Rectangle(xPos,yPos,size,size);
		
	}
	
	/**
	 * is called if the hitpoints of an enemy are 0 or below.
	 * It sets the hitpoints to 0 (in case they were negative)
	 * and sets the enemy's position out of the gamefield
	 */
	public void killed(){
		setHitpoints(0);
		setYPos(705);
	}
	
	/**
	 * moves the enemy one pixel forward
	 */
	public void move(){
//		setYPos(getYPos()+1);  //<- b�se bettina!
//		System.out.println(xPos);
		if(xPos >= 75){
			setYPos(getYPos()-1);
		}else{
			setXPos(getXPos()+1);
		}
		//if(xPos < 20 && yPos == 3) xPos++;
		//else if(xPos == 20 && yPos > 0) yPos--;
		//else if(xPos < 30 && yPos == 0) xPos++;
	}
		
	//welches feld bin ich gerade? returns => isPath, index x,y
	//von x und y ausgehen: links, rechts, oben, unten feld checken: isPath? wenn ja bewege dahin. if(field[x-1][y].isPath() && !field[x-1][y].isLastField()) { field x y.isLastField gehe nach links}
	//verhindern, dass ich im kreis gehe (komme von links, gehe nach links. oh rechts is pfad? gehe nach rechts. links is pfad! gehe nach links...)
	//isLastField flag pr�fen: if isLastPath GEH DA BLO� NICHT HIN!
	
	//aktuelles feld ermitteln:
	//xPos(bzw. yPos) / tileSize => zb. 310 / 30 => 10,3333 (falls result ein float dann :  (int) 10,333) 
	//int result = xPos / tileSize; 
	
	/**
	 * @return Returns the rectangle that represents the enemy
	 */
	public Rectangle getEnemy(){
		return enemy;
	}
	
	/**
	 * @return Returns the current hitpoint of the enemy
	 */
	public int getHitpoints() {
		return hitpoints;
	}

	/**
	 * sets the hitpoints of the enemy to a certain value
	 * @param hitpoints Is the the value of the hitpoints
	 */
	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	/**
	 * @return Returns the enemy's horizontal position in the grid of the gamefield
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets the enemy's horizontal position in the grid
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return Returns the enemy's vertical position in the grid of the gamefield
	 */
	public int getY() {
		return y;
	}

	/**
	 * sets the enemy's vertical position in the grid
	 * @param x
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return Returns the enemy's size
	 */
	public int getSize(){
		return size;
	}

	/**
	 * @return Returns the enemy's position on the x-Axis
	 */
	public int getXPos() {
		return xPos;
	}

	/**
	 * sets the enemy's position on the x-Axis
	 * @param xPos
	 */
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return Returns the enemy's position on the y-Axis
	 */
	public int getYPos() {
		return yPos;
	}

	/**
	 * sets the enemy's position on the y-Axis
	 * @param yPos
	 */
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	
}
