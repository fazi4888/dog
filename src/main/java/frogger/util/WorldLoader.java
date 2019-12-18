package frogger.util;

import frogger.constant.PreloadedActor;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.model.actor.AutomaticActor;
import frogger.model.actor.End;
import frogger.model.actor.Frog;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class WorldLoader {

  private Pane root;
  private GameMode gameMode;
  private GameLevel gameLevel;

  private Frog frogA;
  private Frog frogB;
  private ArrayList<AutomaticActor> movableActors;
  private ArrayList<End> ends;

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

  private void resetActor() {
    frogA.resetActor();
    frogA.setNickname("Unknown");
    frogB.resetActor();
    frogB.setNickname("Unknown");
    ends.forEach(End::resetActor);
    movableActors.forEach(AutomaticActor::resetActor);
  }

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
