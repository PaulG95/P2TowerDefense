package TowerDefense;

import java.util.ArrayList;

public class Shotgun extends Tower{

	public Shotgun(int x, int y, ArrayList<Enemy> enemys){
		super(x,y,enemys);
		
		super.setRange(50);
		super.setSpeed(2);
		super.setDamage(30);
		super.setCost(25);
	}
}
