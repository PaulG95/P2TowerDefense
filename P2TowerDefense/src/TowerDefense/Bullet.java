package TowerDefense;

import java.awt.Rectangle;
/**
 * This class represents a Bullet with main attributes
 * like speed, size and damage.
 * It also has an instance of all enemies 
 * @author Bettina
 */

public class Bullet 
{	
	private Field[][] field;
	private Rectangle bullet;
	private Enemy enemy;
	private Tower tower;
	private int speed, size, x,y, damage;
	private boolean isMoving;
	/**
	 * A bullet is created with a tower, that it belongs to
	 * and an instance of the gameField
	 * @param tower is the tower that the bullet belongs to
	 * @param field
	 */
	public Bullet(Tower tower, Field[][] field)
	{
		this.field = field;		
		this.tower = tower;
		
		damage = tower.getDamage();
		speed = 1;
		size = 8;
		x = field[tower.getX()][tower.getY()].getXPos();
		y = field[tower.getX()][tower.getY()].getYPos();;
		
		isMoving = false;
		
		bullet = new Rectangle(x,y,size,size);	
	}
	
	/**
	 * @return Returns the Rectangle representing this bullet
	 */
	public Rectangle getBullet(){
		return bullet;
	}
	
	/**
	 * Sets the enemy that this bullet is supposed to aim for.
	 * @param enemy
	 */
	public void setEnemy(Enemy enemy){
		this.enemy = enemy;
	}
	
	/**
	 * @return Returns the enemy that is currently the target of this bullet
	 */
	public Enemy getEnemy(){
		return this.enemy;
	}
	
	/**
	 * sets the status of this bullet to isMoving
	 */
	public void startMoving(){
		isMoving = true;
	}
	
	/**
	 *  sets this bullet's isMoving to false
	 */
	public void stopMoving(){
		isMoving = false;
	}
	
	/**
	 * @return Returns true if this bullet is currently moving
	 */
	public boolean isMoving(){
		return isMoving;
	}
	
	/**
	 * Moves the bullet closer to its target
	 * Moves in steps of 5 pixels in x and y direction
	 * If the distance is less than 5 pixels the bullet automatically hits it target 
	 */
	public void moveBullet(){
		if(x - enemy.getXPos() > 5) x -= 5;
		else if(x - enemy.getXPos() < -5) x +=5;
		else x = x - (x - enemy.getXPos());
		
		if(y - enemy.getYPos() > 5) y -= 5;
		else if(y - enemy.getYPos() < -5) y +=5;
		else y = y - (y - enemy.getYPos());
	}
	
	/**
	 * Sets the position of the bullet back to it origin tower
	 * sets the bullet's isMoving to false
	 * sets the bullet's target to null
	 */
	public void reset(){
		setX(field[tower.getX()][tower.getY()].getXPos());
		setY(field[tower.getX()][tower.getY()].getYPos());
		isMoving = false;
		enemy = null;
	}
	
	/**
	 * @return Returns the bullet's position on the x-Axis
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the bullet's position on the x-Axis
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return Returns the bullet's position on the y-Axis
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the bullet's position on the y-Axis
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return Returns the value of damage that this bullet deals
	 */
	public int getDamage() {
		return damage;
	}	
}
