package frogger.model;

public class Life {
  private int currentLife;

  public Life() {
    currentLife = 3;
  }

  public void lose() {
    currentLife--;
  }

  public int getCurrentLife() {
    return currentLife;
  }
}
