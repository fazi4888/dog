package frogger.util;

import frogger.constant.PreloadedActor;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.controller.GameController;
import frogger.model.actor.AutomaticActor;
import frogger.model.actor.End;
import frogger.model.actor.Frog;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * The {@code WorldLoader} is a utility to load the {@link PreloadedActor} according to the game
 * mode and level.
 *
 * @see PreloadedActor
 * @see frogger.model.Game#Game(GameController, GameMode, GameLevel, Pane)
 */
public class WorldLoader {

  /** The pane need to be drawn. */
  private Pane root;
  /** The mode of the game. */
  private GameMode gameMode;
  /** The level of the game. */
  private GameLevel gameLevel;

  private Frog frogA;
  private Frog frogB;
  private ArrayList<AutomaticActor> movableActors;
  private ArrayList<End> ends;

  /**
   * Constructs a new {@code WorldLoader} with the specified parameters.
   *
   * <p>The method will first read the actor, then reset them, finally draw them on the pane.
   *
   * @param gameMode the mode of the game
   * @param gameLevel the level of the game
   * @param root the pane need to be drawn
   */
  public WorldLoader(GameMode gameMode, GameLevel gameLevel, Pane root) {
    this.root = root;
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;

    this.movableActors = new ArrayList<>();
    this.ends = new ArrayList<>();

    readActor();
    resetActor();
    drawActor();
  }

  /** Reads actors from {@link PreloadedActor} */
  private void readActor() {
    frogA = PreloadedActor.frogA;
    frogB = PreloadedActor.frogB;
    ends = PreloadedActor.ends;
    switch (gameLevel) {
      case EASY:
        movableActors = PreloadedActor.easyAutoActors;
        break;
      case MEDIUM:
        movableActors = PreloadedActor.mediumAutoActors;
        break;
      case HARD:
        movableActors = PreloadedActor.hardAutoActors;
        break;
    }
  }

  /**
   * Resets actors.
   *
   * <p>e.g. reset automatic actors to initial position reset the score, life... of the frog to
   * initial value
   */
  private void resetActor() {
    frogA.resetActor();
    frogA.setNickname("Unknown");
    frogB.resetActor();
    frogB.setNickname("Unknown");
    ends.forEach(End::resetActor);
    movableActors.forEach(AutomaticActor::resetActor);
  }

  /** Draws actors on the pane. */
  private void drawActor() {
    root.getChildren().addAll(movableActors);
    root.getChildren().addAll(ends);
    root.getChildren().add(frogA);
    if (isDoubleMode()) root.getChildren().add(frogB);
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return isDoubleMode() ? frogB : null;
  }

  public ArrayList<AutomaticActor> getMovableActors() {
    return movableActors;
  }

  public ArrayList<End> getEnds() {
    return ends;
  }

  private boolean isDoubleMode() {
    return gameMode == GameMode.DOUBLE;
  }
}
