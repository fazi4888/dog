package frogger.util;

import frogger.constant.Direction;
import frogger.constant.FileName;
import frogger.model.actor.Frog;
import javafx.animation.AnimationTimer;

public class HomeAnimation {

  private Frog frog;

  public HomeAnimation() {
    frog = new Frog(FileName.IMAGE_FROG_PREFIX + "Right.png", 0, 0);
    frog.setY(640);
  }

  public Frog getFrog() {
    return frog;
  }

  private AnimationTimer timer =
      new AnimationTimer() {
        @Override
        public void handle(long now) {
          if (now % 17 == 0) frog.jump(Direction.RIGHT, true);
          if (frog.getX() > 600) frog.setX(-20);
        }
      };

  public void start() {
    timer.start();
  }
}
