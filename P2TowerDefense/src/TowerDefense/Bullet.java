package TowerDefense;

import java.awt.Rectangle;

public class Bullet 
{
	
	private Field[][] field;
	private Rectangle bullet;
	private Enemy enemy;
	private Tower tower;
	private int speed, size, x,y, damage;
	private boolean isMoving;
	
	public Bullet(Enemy enemy, Tower tower, Field[][] field)
	{
		this.field = field;		
		this.enemy = enemy;
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
