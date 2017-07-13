package TowerDefense;

import java.util.ArrayList;

import javax.swing.Timer;
/**
 * The BulletController controls all actions of the bullets. It updates
 * the bullet movement. It also checks whether there is a collision between 
 * any bullets and enemies. 
 * @author Bettina
 *
 */
public class BulletController {

	private ArrayList<Tower> towers;
	private ArrayList<Enemy> enemys;
	/**
	 * The BulletController is created with everything he needs
	 * to control all the bullets
	 * @param view 
	 * @param towers ArrayList that contains all the towers that are currently in the game
	 * @param enemys ArrayList that contains all the enemies that are currently in the game
	 */
	public BulletController(View view, ArrayList<Tower> towers, ArrayList<Enemy> enemys)
	{
		GamePanel gamePanel = view.getGamePanel();
		this.towers = towers;
		this.enemys = enemys;
		
		
		Timer bulletTimer = new Timer(20,e->{															//Bullet-Timer	
			for(Tower t: towers)																		//alle existieren Tower durchgehen
			{
				for(Bullet b: t.getBullets())															//alle existierenden Bullets des jeweiligen
				{																						//Turmes durchgehen
					if(b.isMoving())																	//wenn die Bullet sich gerade bewegt	
					{
						b.moveBullet();																	//Bullet fortbewegen
						gamePanel.repaint();															//GamePanel updated
						
						if(b.getX() == b.getEnemy().getXPos() && b.getY() == b.getEnemy().getYPos())	//Wenn Bullet und Enemy kollidieren
						{
							if(b.getEnemy().getHitpoints()- b.getDamage() <= 0)							//und wenn Enemy kein Leben mehr hat
							{
								b.getEnemy().killed();													//dann Enemy töten	
							}
							else{
								b.getEnemy().setHitpoints(b.getEnemy().getHitpoints()-b.getDamage());	//wenn Enemy noch lebt, Hitpoints aktualisieren
							}
							b.reset();
						}
					}
				}
			}
		});
		bulletTimer.start();
	}
}
