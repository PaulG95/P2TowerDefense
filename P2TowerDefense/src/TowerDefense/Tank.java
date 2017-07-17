package TowerDefense;

public class Tank extends Enemy{

	public Tank(Field[][] field){
		super(field);
		
		super.setEnemy(25);
		super.setHitpoints(40);
		super.setDamage(4);
		super.setGold(3);
	}
}
