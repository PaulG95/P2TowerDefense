package TowerDefense;

import java.util.ArrayList;

import javax.swing.Timer;
/**
 * The EnemyController controls all the actions of
 * the enemies like updating the position
 * @author Bettina
 *
 */
public class EnemyController {
	/**
	 * The Enemy is created with everything that he needs to 
	 * control the enemies
	 * @param view
	 * @param field
	 * @param enemys ArrayList that contains all enemies that are currently in the game
	 */
	public EnemyController(View view, Field[][] field, ArrayList<Enemy> enemys)
	{
		GamePanel gamePanel = view.getGamePanel();
		gamePanel.setEnemys(enemys);
		
		Enemy enemy = new Runner(field);
		enemys.add(enemy);
		
		Timer enemyTimer = new Timer(40,l->{
			for(Enemy e: enemys)
			{
				if(e.getEnemy().y<700)
				{
					e.move();
				}
			}
			gamePanel.repaint();
		});
		
		enemyTimer.start();
	}	
}
