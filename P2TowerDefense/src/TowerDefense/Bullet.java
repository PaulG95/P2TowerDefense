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
	
	public Rectangle getBullet(){
		return bullet;
	}
	
	public void setEnemy(Enemy enemy){
		this.enemy = enemy;
	}
	
	public Enemy getEnemy(){
		return this.enemy;
	}
	
	public void startMoving(){
		isMoving = true;
	}
	
	public void stopMoving(){
		isMoving = false;
	}
	
	public boolean isMoving(){
		return isMoving;
	}
	
	public void moveBullet(){
		if(x - enemy.getXPos() > 5) x -= 5;
		else if(x - enemy.getXPos() < -5) x +=5;
		else x = x - (x - enemy.getXPos());
		
		if(y - enemy.getYPos() > 5) y -= 5;
		else if(y - enemy.getYPos() < -5) y +=5;
		else y = y - (y - enemy.getYPos());
	}
	
	public void reset(){
		setX(field[tower.getX()][tower.getY()].getXPos());
		setY(field[tower.getX()][tower.getY()].getYPos());
		isMoving = false;
		enemy = null;
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

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	
}
