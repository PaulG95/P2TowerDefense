package highscores;

public class Main {
    public static void main(String[] args) {
        HighscoreManager hm = new HighscoreManager();
        hm.addScore("Test 1",240);
        hm.addScore("Test 2",300);
        hm.addScore("Test 3",220);
        hm.addScore("Test 4",100);
        hm.addScore("Test 5",270);

        System.out.print(hm.getHighscoreString());
    }
}