package frogger.util;

import frogger.constant.Direction;
import frogger.constant.FileName;
import frogger.model.actor.Frog;
import javafx.animation.AnimationTimer;

/**
 * The {@code HomeAnimation} class creates a new {@link Frog} and keeps it jumping on the screen.
 *
 * @see SceneSwitch#switchToHome()
 */
public class HomeAnimation {

  /** The Frog jumping on the screen. */
  private Frog frog;

  /** Creates a new Frog and puts it in the initial position */
  public HomeAnimation() {
    frog = new Frog(FileName.IMAGE_FROG_PREFIX + "Right.png", 0, 0);
    frog.setY(640);
  }

  /**
   * Returns the {@link #frog} jumping on the screen.
   *
   * @return the {@link #frog} jumping on the screen
   */
  public Frog getFrog() {
    return frog;
  }

  /**
   * AnimationTimer for the jumping frog.
   *
   * <p>The {@link #frog} will jump every 17 nanoseconds.
   */
  private AnimationTimer timer =
      new AnimationTimer() {
        @Override
        public void handle(long now) {
          if (now % 17 == 0) frog.jump(Direction.RIGHT, true);
          if (frog.getX() > 600) frog.setX(-20);
        }
      };

  /** Lets the {@link #frog} begin to jump. */
  public void start() {
    timer.start();
  }
}
