package TowerDefense;

import java.util.ArrayList;
/**
 * The TowerController controls all actions of the towers like
 * setting Targets for the bullets, when there is an enemy in range.
 * @author Bettina
 */

import javax.swing.Timer;

public class TowerController {
	
	private ArrayList<Tower> towers;
	private ArrayList<Enemy> enemys;
	/**
	 * The TowerController is created with everything he needs
	 * to control the towers
	 * @param view
	 * @param field
	 * @param towers ArrayList that contains all the towers that are currently in the game
	 * @param enemys ArrayList that contains all the enemies that are currently in the game
	 */
	public TowerController(View view, Field[][] field, ArrayList<Tower> towers, ArrayList<Enemy> enemys)
	{
		GamePanel gamePanel = view.getGamePanel();
		this.towers = towers;
		this.enemys = enemys;
		gamePanel.setTowers(towers);
		
		Tower tower0 = new Tower(7,4, field, enemys);
		Tower tower1 = new Tower(1,11,field, enemys);
		
		towers.add(tower0);
		towers.add(tower1);
		
		gamePanel.setBullets(tower0.getBullets());
		gamePanel.addBullets(tower1.getBullets());
		
		Timer towerTimer = new Timer(1000,e->															//TOWER-TIMER
		{
			for(Tower t: towers){															//Alle Tower in der ArrayList durchgehen 
				if(t.checkRange())															//Kontrollieren ob Gegner in Reichweite ist
				{
					if(t.getActiveBullet() == 19) t.setActiveBullet(0);						//counter für die einzelnen Bullets bei Bedarf zuruecks.
					else t.setActiveBullet(t.getActiveBullet()+1);							//sonst Counter eins hochzählen
					t.getBullets().get(t.getActiveBullet()).setEnemy(t.getTarget());		//Bullet den Enemy übergeben
					t.getBullets().get(t.getActiveBullet()).startMoving();					//Bullet beweglich machen
				}
			}
		});
		
		towerTimer.start();
	}
	
}
