package TowerDefense;

import java.util.ArrayList;

public class Sniper extends Tower{

	public Sniper(int x, int y, ArrayList<Enemy> enemys){
		super(x,y,enemys);
		
		super.setRange(150);
		super.setSpeed(3);
		super.setDamage(40);
		super.setCost(40);
	}
}
