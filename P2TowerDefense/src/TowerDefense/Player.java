package TowerDefense;

/**
 * This Class represents the Player
 * It saves his/her name, score, lifepoints and time
 * @author Bettina
 *
 */
public class Player 
{

	private String name;
	private int score, timeMin, timeSek, life;
	
	public Player(String name)
	{
		this.name = name;
		score = 0;
		timeMin = 0;
		timeSek = 0;
		life = Values.PLAYER_LIFE;
	}

	/**
	 * @return Returns the score of the Player
	 */
	public int getScore() 
	{
		return score;
	}

	/**
	 * Sets the score of the Player
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return Returns the minutes of this Player
	 */
	public int getTimeMin() {
		return timeMin;
	}

	/**
	 * Sets the minutes of the Player
	 * @param timeMin
	 */
	public void setTimeMin(int timeMin) {
		this.timeMin = timeMin;
	}
	
	/**
	 * @return Returns the seconds of this Player
	 */
	public int getTimeSek() {
		return timeSek;
	}

	/**
	 * Sets the seconds for this Player
	 * @param timeSek
	 */
	public void setTimeSek(int timeSek) {
		this.timeSek = timeSek;
	}
	
	/**
	 * Returns the Name of this Player
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Returns the life of this Player
	 */
	public int getLife() {
		return life;
	}

	/**
	 * Sets the lifepoints for this Player
	 * @param life
	 */
	public void setLife(int life) {
		this.life = life;
	}
	
}
