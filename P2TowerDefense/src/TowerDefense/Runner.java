package TowerDefense;

public class Runner extends Enemy{
	
	public Runner(Field[][] field){
		super(field);
		
		super.setSize(10);
		super.setEnemy(10);
		super.setHitpoints(20);
		super.setDamage(2);
		super.setGold(2);
	}
}
