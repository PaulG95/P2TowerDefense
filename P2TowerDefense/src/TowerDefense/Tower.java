package TowerDefense;

import java.util.ArrayList;
/**
 * This class represents a Tower with main attributes like range,
 * damage, a position, and an ArrayList of bullets.
 * It also has an instance of all the enemies.
 * @author Bettina 
 */

public class Tower {
	
	private int range; 
	private int damage;	
	private int x,y, xPos,yPos, size;
	private Enemy target;
	private Field[][] field;
	private ArrayList<Enemy> enemys;
	private ArrayList<Bullet> bullets;
	private int activeBullet;
	private boolean inRange;
	
	/**
	 * A Tower is created with an exact position,
	 * an instance of the gamefield and a list
	 * of all the enemies
	 * @param x defines the position on the x-axis
	 * @param y defines the position on the y-axis
	 * @param field
	 * @param enemys
	 */
	public Tower(int x, int y, Field[][] field, ArrayList<Enemy> enemys){
		
		this.bullets = new ArrayList<>();
		this.enemys = enemys;
		this.field = field;
		this.size = Values.FIELD_SIZE;
		this.x = x;
		this.y = y;
			
		inRange = false;
		range = 150;
		damage = 1;
		
		xPos = field[x][y].getXPos();
		yPos = field[x][y].getYPos();
		
		for(int i=0; i<20; i++){
			Bullet bullet = new Bullet(this,field);			//20 Bullets erstellen
			bullets.add(bullet);							//und dem Array hinzufügen
		}
		activeBullet = 0;
	}
		
	public boolean checkRange(){
		int midX = field[x][y].getXPos()+Values.FIELD_SIZE/2;
		int midY = field[x][y].getYPos()+Values.FIELD_SIZE/2;
		inRange = false;
		
		for(Enemy e: enemys){
			
			if(xPos-range<e.getXPos()&&xPos+range>e.getXPos())
			{
				if(yPos-range<e.getYPos()&&yPos+range>e.getYPos())
				{
					inRange=true;
					setTarget(e);
					break;
				}
			}
		}
		return inRange;
	}
	
	public void setTarget(Enemy enemy){
		target = enemy;
	}
	
	public Enemy getTarget() {
		return target;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public int getActiveBullet() {
		return activeBullet;
	}

	public void setActiveBullet(int activeBullet) {
		this.activeBullet = activeBullet;
	}
}
