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
	
	private ArrayList<Enemy> enemys;
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
		this.enemys = enemys;
		gamePanel.setEnemys(enemys);
		
		Enemy enemy = new Enemy(field);
		enemys.add(enemy);
		
		Timer enemyTimer = new Timer(10,e->{
			if(enemy.getEnemy().y<700)
			{
				enemy.move();
			}
			
			gamePanel.repaint();
		});
		
		enemyTimer.start();
	}	
}
