import java.util.ArrayList;

public class Player {
    private String userName;
    private int score;
    private int gamesPlayed;
    private String playerID;

    public Player(String userName, int score, int gamesPlayed, String playerID) {
        this.userName = userName;
        this.score = score;
        this.gamesPlayed = gamesPlayed;
        this.playerID = playerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

}
