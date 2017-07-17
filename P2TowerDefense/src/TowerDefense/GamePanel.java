package TowerDefense;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * This class represents the GamePanel which is painting 
 * all the models.
 * @author Bettina
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private ArrayList<Enemy> enemys;
	private ArrayList<Tower> towers;
	private ArrayList<Bullet> bullets;
	private Rectangle hoveredField;
	
	public GamePanel(Field[][] field)
	{
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		if(bullets != null)
		{	
			for(Bullet b: bullets)
			{
				g.fillRect(b.getX(), b.getY(), b.getBullet().width, b.getBullet().height);
			}
		}	
		
		g.setColor(Color.DARK_GRAY);
		if(towers != null)
		{
			for(Tower t: towers)
			{
				g.fillRect(t.getX(), t.getY(), t.getSize(), t.getSize());
			}
		}
		
		g.setColor(Color.BLUE);
		if(enemys != null)
		{
			for(Enemy e: enemys)
			{
				g.fillRect(e.getXPos(), e.getYPos(), e.getEnemy().width, e.getEnemy().height);
			}
		}
		
		g.setColor(Color.CYAN);
		if(hoveredField != null)
		{
			g.fillRect(hoveredField.x, hoveredField.y, hoveredField.width, hoveredField.height);
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
	
	public void setHoveredField(Rectangle field){
		this.hoveredField = field;
	}
}
