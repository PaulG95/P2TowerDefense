package TowerDefense;

public class Fighter extends Enemy
{
	
	public Fighter(Field[][] field){
		super(field);
		
		super.setSize(10);
		super.setEnemy(10);
		super.setHitpoints(30);
		super.setDamage(1);
		super.setGold(1);
	}	
}
