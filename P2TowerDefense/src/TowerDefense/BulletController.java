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
			for(Tower t: towers)
			{
				for(Bullet b: t.getBullets())
				{										//jede Bullet durchgehen
					if(b.isMoving())														//wenn die Bullet beweglich ist	
					{
						b.moveBullet();														//Bullet bewegen
						gamePanel.repaint();
						
						if(b.getX() == b.getEnemy().getXPos() && b.getY() == b.getEnemy().getYPos())			//Wenn Bullet und Enemy kollidieren
						{
							if(b.getEnemy().getHitpoints()- b.getDamage() <= 0)						//wenn Enemy kein Leben mehr hat
							{
								b.getEnemy().killed();													//Enemy töten	
								b.reset();														//Bullet zurücksetzten
							}
							else{
								b.getEnemy().setHitpoints(b.getEnemy().getHitpoints()-b.getDamage());			//wenn Enemy noch Leben hat Hitpoint aktualisieren
								b.reset();														//Bullet zurücksetzen
							}
						}
					}
				}
			}
		});
		bulletTimer.start();
	}
}
