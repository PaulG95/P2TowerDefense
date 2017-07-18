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
	private int cost;
	private int speed;
	private int activeBullet;
	private int x,y,midX,midY,size;
	private Enemy target;
	private ArrayList<Enemy> enemys;
	private ArrayList<Bullet> bullets;
	private boolean inRange;
	
	/**
	 * A Tower is created with an exact position,
	 * an instance of the gamefield and a list
	 * of all the enemies
	 * @param x defines the position on the x-axis
	 * @param y defines the position on the y-axis
	 * @param enemys
	 */
	
	public Tower(int x, int y, ArrayList<Enemy> enemys)
	{
		this.bullets = new ArrayList<>();
		this.enemys = enemys;
		this.size = Values.FIELD_SIZE;
		
		inRange = false;
		range = 150;
		damage = 1;
		
		this.x = x;
		this.y = y;
		this.midX = x+Values.FIELD_SIZE/2;
		this.midY = y+Values.FIELD_SIZE/2;
		
		for(int i=0; i<20; i++){
			Bullet bullet = new Bullet(this);			//20 Bullets erstellen
			bullets.add(bullet);							//und dem Array hinzufügen
		}
		activeBullet = 0;
	}
		
	/**
	 * Checks if there is an enemy in shooting range of this tower.
	 * @return Returns true if there is an enemy in range.
	 */
	public boolean checkRange(){
		inRange = false;
		
		for(Enemy e: enemys){
			if(midX-range < e.getXPos() && midX+range > e.getXPos())
			{
				if(midY-range < e.getYPos() && midY+range > e.getYPos())
				{
					inRange=true;
					setTarget(e);
					break;
				}
			}
		}
		return inRange;
	}
	
	/**
	 * Sets an enemy as a new target of this tower
	 * @param enemy Is the enemy which is the new target
	 */
	public void setTarget(Enemy enemy){
		target = enemy;
	}
	
	/**
	 * @return Returns the enemy which is the current target of this tower
	 */
	public Enemy getTarget() {
		return target;
	}
	
	/**
	 * @return Returns the value of the damage that this tower deals
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * sets a new value for the damage of this tower
	 * @param damage is the new damage value
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * @return Returns the shooting range of this tower
	 */
	public int getRange() {
		return range;
	}
	
	/**
	 * Sets the range of this tower 
	 * @param range
	 */
	public void setRange(int range) {
		this.range = range;
	}
	
	/**
	 * @return Returns the cost of this tower
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * sets the cost of this tower which the player
	 * has to pay to build it
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * @return Returns the speed of this tower
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Sets the firing rate (speed) of this tower
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return Returns this tower's position on the x-Axis
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets this tower's horizontal position in the grid
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return Returns this tower's position on the y-Axis
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets this tower's vertical position in the grid
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return Returns the size of this tower
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return Returns an ArrayList of all the bullets which belong to this tower
	 */
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	/**
	 * @return Returns the number of the currently active bullet.
	 */
	public int getActiveBullet() {
		return activeBullet;
	}

	/**
	 * Sets the number of the active Bullet
	 * @param activeBullet
	 */
	public void setActiveBullet(int activeBullet) {
		this.activeBullet = activeBullet;
	}
}
