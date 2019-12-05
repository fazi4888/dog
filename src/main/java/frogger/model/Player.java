package frogger.model;

public class Player {

  private String name;
  private int life;
  private int score;

  public Player() {
    this("Unknown");
  }

  public Player(String name) {
    this.name = name;
    this.life = 3;
    this.score = 0;
  }

  public String getName() {
    return name;
  }

  public int getLife() {
    return life;
  }

  public int getScore() {
    return score;
  }

  public void loseLife() {
    life--;
  }

  public void gainScore(int value) {
    score += value;
  }

  public void loseScore(int value) {
    score -= value;
  }
}
