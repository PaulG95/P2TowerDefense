package TowerDefense;

public class Player {

	private String name;
	private int score, timeMin, timeSek, life;
	
	public Player(String name)
	{
		this.name = name;
		score = 0;
		timeMin = 0;
		timeSek = 0;
		setLife(Values.PLAYER_LIFE);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTimeMin() {
		return timeMin;
	}

	public void setTimeMin(int timeMin) {
		this.timeMin = timeMin;
	}

	public int getTimeSek() {
		return timeSek;
	}

	public void setTimeSek(int timeSek) {
		this.timeSek = timeSek;
	}

	public String getName() {
		return name;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
}
