package TowerDefense;

import java.util.ArrayList;

public class Shooter extends Tower{

	
	public Shooter(int x, int y, ArrayList<Enemy> enemys){
		super(x,y,enemys);
		
		super.setRange(100);
		super.setSpeed(2);
		super.setDamage(20);
		super.setCost(20);	
	}
}
