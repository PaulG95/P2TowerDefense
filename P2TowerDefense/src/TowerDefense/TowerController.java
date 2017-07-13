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
	private GamePanel gamePanel;
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
		this.gamePanel = view.getGamePanel();
		this.towers = towers;
		this.enemys = enemys;
		gamePanel.setTowers(towers);

		Timer towerTimer = new Timer(1000,e->												//TOWER-TIMER
		{
			for(Tower t: towers){															//Alle existierenden Tower durchgehen 
				if(t.checkRange())															//Kontrollieren ob Gegner in Reichweite ist
				{
					if(t.getActiveBullet() == 19) t.setActiveBullet(0);						//counter für die activeBullet bei Bedarf zuruecks.
					else t.setActiveBullet(t.getActiveBullet()+1);							//sonst activeBullet eins hochzählen
					t.getBullets().get(t.getActiveBullet()).setEnemy(t.getTarget());		//Bullet den Enemy als Ziel übergeben
					t.getBullets().get(t.getActiveBullet()).startMoving();					//Bullet beweglich machen
				}
			}
		});
		
		towerTimer.start();
	}
	
	public void newTower(int x, int y)
	{
		Tower tower = new Tower(x,y,enemys);
		if(!towers.isEmpty())
		{
			this.gamePanel.addBullets(tower.getBullets());		
		}
		else 
		{
			this.gamePanel.setBullets(tower.getBullets());
		}
		towers.add(tower);
	}
}
