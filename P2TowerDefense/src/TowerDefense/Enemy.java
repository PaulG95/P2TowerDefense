package TowerDefense;

import java.awt.Rectangle;

public class Enemy 
{
	private	Rectangle enemy;
	
	private int hitpoints;
	private int x,y;
	private int xPos,yPos;
	private int size;
	private Field field[][];
	
	public Enemy(Field[][] field)
	{
		this.field = field;
	
		hitpoints = 5;
		size = 10;
		
		x = Values.ENEMY_START_X;				//Position im Raster
		y = Values.ENEMY_START_Y;
		
		xPos = field[x][y].getXPos();				//Tatsächliche Koordinaten
		yPos = field[x][y].getYPos();
		
		enemy = new Rectangle(xPos,yPos,size,size);
		
	}
	
	public void killed(){
		setHitpoints(0);
		setYPos(705);
	}
	
	public void move(){
		setYPos(getYPos()+1);
	}
	
	public Rectangle getEnemy(){
		return enemy;
	}
	
	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getSize(){
		return size;
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	
}
