package frogger.model.actor;

import frogger.constant.FileName;
import javafx.scene.image.Image;

/**
 * A {@code End} is a home of the {@link Frog} in the game.
 */
public class End extends AutomaticActor {

  /** Is there a fly among the five ends. */
  static boolean isFlyIn = false;
  /** Is there a fly in this end. */
  private boolean isFlyInThisEnd = false;

  private Image end;
  private Image frogEnd;
  private Image flyEnd;

  boolean activated = false;

  public End(int xpos, int ypos) {
    super(FileName.IMAGE_END, xpos, ypos, 56, 56, 0);
    end = new Image(FileName.IMAGE_END, 56, 56, true, true);
    frogEnd = new Image(FileName.IMAGE_END_FROG, 56, 56, true, true);
    flyEnd = new Image(FileName.IMAGE_END_FLY, 56, 56, true, true);
  }

  @Override
  public void resetActor() {
    super.resetActor();
    setImage(end);
    activated = false;
  }

  @Override
  public void act(long now) {
    if (isActivated()) return;
    if (!isFlyIn && now % 120 == 0) {
      setFly();
    }
    if (isFlyInThisEnd && now % 100 == 0) {
      clearFly();
    }
  }

  /** Sets a fly in the end. */
  private void setFly() {
    int randomIndex = (int) (Math.random() * 5);
    if (randomIndex == 3 && !isFlyIn) {
      setImage(flyEnd);
      isFlyIn = true;
      isFlyInThisEnd = true;
    }
  }

  /** Clears the fly in the end. */
  private void clearFly() {
    setImage(end);
    isFlyIn = false;
    isFlyInThisEnd = false;
  }

  /**
   * Called when the frog touch the end.
   *
   * <p>Sets a frog in the end.
   */
  public void setFrog() {
    if (isFlyInThisEnd) {
      isFlyInThisEnd = false;
      isFlyIn = false;
    }
    setImage(frogEnd);
    activated = true;
  }

  public boolean isActivated() {
    return activated;
  }

  public boolean isFlyInThisEnd() {
    return isFlyInThisEnd;
  }
}
