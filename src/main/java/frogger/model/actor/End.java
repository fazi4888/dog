package frogger.model.actor;

import frogger.constant.FileName;
import javafx.scene.image.Image;

public class End extends AutomaticActor {

  boolean activated = false;

  private Image endWithoutFrog;
  private Image endWithFrog;

  public End(int xpos, int ypos) {
    super(FileName.IMAGE_END, xpos, ypos, 56, 56, 0);
    endWithoutFrog = new Image(FileName.IMAGE_END, 56, 56, true, true);
    endWithFrog = new Image(FileName.IMAGE_END_FROG, 56, 56, true, true);
  }

  @Override
  public void resetActor() {
    super.resetActor();
    setImage(endWithoutFrog);
    activated = false;
  }

  public void setEnd() {
    setImage(endWithFrog);
    activated = true;
  }

  public boolean isActivated() {
    return activated;
  }
}
