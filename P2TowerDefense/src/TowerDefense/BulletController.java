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
		
		Timer bulletTimer = new Timer(10,e->{															//Bullet-Timer	
			for(Tower t: towers)																		//alle existieren Tower durchgehen
			{
				int speedDif = 1;																		//Variable zur Speedeinteilung
				for(Bullet b: t.getBullets())															//alle existierenden Bullets des jeweiligen
				{																						//Turmes durchgehen
					if(speedDif%t.getSpeed() == 0)														//Wenn speed dieser Bullet dran ist und
					{
						if(b.isMoving())																//wenn die Bullet sich gerade bewegt	
						{
							b.moveBullet();																//Bullet fortbewegen
							gamePanel.repaint();														//GamePanel updated
							
							if(b.getX() == b.getEnemy().getXPos() && b.getY() == b.getEnemy().getYPos())//Wenn Bullet und Enemy kollidieren
							{
								if(b.getEnemy().getHitpoints()- b.getDamage() <= 0)						//und wenn Enemy kein Leben mehr hat
								{
									b.getEnemy().killed();												//dann Enemy töten	
								}
								else{
									b.getEnemy().setHitpoints(b.getEnemy().getHitpoints()-b.getDamage());//wenn Enemy noch lebt, Hitpoints aktualisieren
								}
								b.reset();																//Bullet auf Turm zurücksetzen
							}
						}
					}
					if(speedDif == 4) speedDif = 1;														//Wenn speedDif einmal durchgelaufen: zurücks.
					else speedDif++;																	//sonst hochzählen
				}
			}
		});
		
		bulletTimer.start();
	}
}
