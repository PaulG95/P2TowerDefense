package TowerDefense;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * This class represents the GamePanel which is painting 
 * all the models.
 * @author Bettina
 *
 */
public class GamePanel extends JPanel {

	private ArrayList<Enemy> enemys;
	private ArrayList<Tower> towers;
	private ArrayList<Bullet> bullets;
	private Field[][] field;
	
	public GamePanel(Field[][] field)
	{
		this.field = field;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(enemys != null)
		{
			for(Enemy e: enemys)
			{
				g.fillRect(e.getXPos(), e.getYPos(), e.getEnemy().width, e.getEnemy().height);
			}
		}
		if(towers != null)
		{
			for(Tower t: towers)
			{
				g.fillRect(field[t.getX()][t.getY()].getXPos(), field[t.getX()][t.getY()].getYPos(), t.getSize(), t.getSize());
			}
		}
		
		g.setColor(Color.RED);
		if(bullets != null)
		{	
			for(Bullet b: bullets)
			{
				g.fillRect(b.getX(), b.getY(), b.getBullet().width, b.getBullet().height);
			}
		}	
	}
	
	public void setTowers(ArrayList<Tower> towers)
	{
		this.towers = towers;
	}
	
	public void setEnemys(ArrayList<Enemy> enemys)
	{
		this.enemys = enemys;
	}
	
	public void setBullets(ArrayList<Bullet> bullets)
	{
		this.bullets = bullets;
	}
	
	public void addBullets(ArrayList<Bullet> bullets)
	{
		for(Bullet b: bullets)
		{
			this.bullets.add(b);
		}
	}	
}
