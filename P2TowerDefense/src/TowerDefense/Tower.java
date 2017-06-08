package TowerDefense;

import java.util.ArrayList;

public class Tower {
	
	private int range; 
	private int damage;	
	private int x,y, xPos,yPos, size;
	private Enemy target;
	private Field[][] field;
	private ArrayList<Enemy> enemys;
	private boolean inRange;
	
	
	public Tower(int x, int y, Field[][] field, ArrayList<Enemy> enemys){
		
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
}
