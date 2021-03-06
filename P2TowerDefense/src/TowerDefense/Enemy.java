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
	private int damage;
	private int gold;
	private int x,y;
	private int xPos,yPos;
	private int lastPathX;
	private int lastPathY;
	private Field[][] enemyField;
	private Field[][] field;
	private int moveCounter;
	
	private boolean reachedEnd;
	/**
	 * An enemy is created with an instance of the gameField
	 * @param field
	 */
	public Enemy(Field[][] field)
	{
		this.field = field;
		reachedEnd = false;
		
		enemyField = new Field[Values.AMOUNT_OF_XFIELDS][Values.AMOUNT_OF_YFIELDS];
	
		for(int x=0; x<Values.AMOUNT_OF_XFIELDS; x++)
		{
			for(int y=0; y<Values.AMOUNT_OF_YFIELDS; y++)
			{
				enemyField[x][y] = new Field(x*Values.FIELD_SIZE,y*Values.FIELD_SIZE);
			}
		}
			
		x = Values.ENEMY_START_X;				//Position im Raster
		y = Values.ENEMY_START_Y;
		
		xPos = enemyField[x][y].getXPos();				//Tatsächliche Koordinaten
		yPos = enemyField[x][y].getYPos();
		
		moveCounter = 0;

		
		//Setting the Enemy Path
		for (int x=0; x<3; x++){
			enemyField[x][13].setPath(true);
		}
		for (int y=3; y<14; y++){
			enemyField[2][y].setPath(true);
		}
		for (int x=2; x<20; x++){
			enemyField[x][3].setPath(true);
			if(x==10){
				x = 12;
			}
		}
		for (int y=3; y<9; y++){
			enemyField[10][y].setPath(true);
		}
		for (int x=6; x<10; x++){
			enemyField[x][8].setPath(true);
		}
		for (int y=8; y<16; y++){
			enemyField[6][y].setPath(true);
		}
		for (int x=6; x<17; x++){
			enemyField[x][15].setPath(true);
		}
		for (int y=9; y<16; y++){
			enemyField[16][y].setPath(true);
		}
		for (int x=13; x<17; x++){
			enemyField[x][9].setPath(true);
		}
		for (int y=3; y<10; y++){
			enemyField[13][y].setPath(true);
		}
	}
	
	/**
	 * is called if the hitpoints of an enemy are 0 or below.
	 * It sets the hitpoints to 0 (in case they were negative)
	 * and sets the enemy's position out of the gamefield
	 */
	public void killed(){
		setHitpoints(0);
	}
	
	/**
	 * moves the enemy one pixel forward
	 */
	public void move(){
		
		int resultX = (int)(xPos/Values.FIELD_SIZE);
		int resultY = (int)(yPos/Values.FIELD_SIZE);
		
		if(xPos == 570){
			reachedEnd = true;
		}else{
			if(xPos <= 31){
				xPos ++;
				if(xPos == 30){
					enemyField[0][13].setLastPath(true);
					lastPathX = 0;
					lastPathY= 13;
				}
			}else{
				if(enemyField[resultX-1][resultY].isPath() && !enemyField[resultX-1][resultY].isLastPath()){
					updateFieldState(resultX, resultY);
					//Gehe nach links
					xPos --;
				}else if(enemyField[resultX][resultY-1].isPath() && !enemyField[resultX][resultY-1].isLastPath()){
					updateFieldState(resultX, resultY);
					enemyField[resultX][resultY].setLastPath(true);
					//Gehe nach Oben
					yPos --;
				}else if(enemyField[resultX+1][resultY].isPath() && !enemyField[resultX+1][resultY].isLastPath()){
					updateFieldState(resultX, resultY);
					enemyField[resultX][resultY].setLastPath(true);
					//Gehe nach Rechts
					xPos ++;
				}else if(enemyField[resultX][resultY+1].isPath() && !enemyField[resultX][resultY+1].isLastPath()){
					updateFieldState(resultX, resultY);
					enemyField[resultX][resultY].setLastPath(true);
					//Gehe nach Unten
					yPos ++;
				}else{
					System.out.println("Hallo");
					//DestroyEnemy
					//playerHealth - enemyDmg;
				}
			}
		}
	}
	
	public void updateFieldState(int resultX, int resultY)
	{
		enemyField[resultX][resultY].setLastPath(true);
		field[resultX][resultY].setOccupied(this);
		field[lastPathX][lastPathY].releaseField();
		if(moveCounter < 30)
		{
			moveCounter++;
		} else
		{
			lastPathX = resultX;
			lastPathY = resultY;
			moveCounter = 0;
		}
		
	} 
	
	public boolean reachedEnd(){
		return reachedEnd;
	}
	
	/**
	 * @return Returns the rectangle that represents the enemy
	 */
	public Rectangle getEnemy(){
		return enemy;
	}
	
	/**
	 * creates the rectangle that represents the enemy
	 * @param size Is the side length of this enemy
	 */
	public void setEnemy(int size){
		this.enemy = new Rectangle(xPos,yPos,size,size);
	}
	
	/**
	 * @return Returns the current hitpoints of the enemy
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
	 * @return Returns the amount of gold that this enemy is worth
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * sets the amount of gold this enemy is worth
	 * @param gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	/**
	 * @return Returns the damage this enemy deals once it reaches its goal
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Sets the damage this enemy deals
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.damage = damage;
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
