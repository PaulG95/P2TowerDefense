package TowerDefense;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
/**
 * The EnemyController controls all the actions of
 * the enemies like updating the position
 * @author Bettina
 *
 */
public class EnemyController {
	
	int counter;
	Enemy eny1,eny2;
	
	private Player player;
	
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
		
		Timer enemyTimer = new Timer(10,l->{
			if(counter == 4000)
			{
				eny1 = new Fighter(field);
				enemys.add(eny1);
			}
			else if(counter == 8000)
			{
				eny2 = new Tank(field);
				enemys.add(eny2);
			}
			for (Iterator<Enemy> iterator = enemys.iterator(); iterator.hasNext(); ) {
			    Enemy e = iterator.next();
			    if (e.getHitpoints() == 0) {
			    	view.getInfos().setScoreLbl(String.valueOf(e.getGold()));
			        iterator.remove();
			    } else if (e.reachedEnd())
			    {
			    	player.setLife(player.getLife()-e.getDamage());
			    	view.getInfos().setLifeLbl(player.getLife());
			    	iterator.remove();
			    }
			}
			for(Enemy e: enemys)
			{
				if(e.getEnemy().y<700)
				{
					e.move();
				}
			}
			gamePanel.repaint();
			counter+=40;
		});
		
		enemyTimer.start();
	}	
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
}
