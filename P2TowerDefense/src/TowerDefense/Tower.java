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
		
	/**
	 * Checks if there is an enemy in shooting range of this tower.
	 * @return Returns true if there is an enemy in range.
	 */
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
	 * @return Returns this tower's horizontal positions in the grid of the gamefield
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
	 * @return Returns this tower's vertical positions in the grid of the gamefield
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
