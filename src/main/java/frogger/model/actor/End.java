package frogger.model.actor;

import frogger.constant.FileName;
import javafx.scene.image.Image;

public class End extends Actor {

  boolean activated = false;

  private Image endWithoutFrog;
  private Image endWithFrog;

  public End(int xpos, int ypos) {
    super(FileName.IMAGE_END, xpos, ypos, 74, 74);
    endWithoutFrog = new Image(FileName.IMAGE_END, 74, 74, true, true);
    endWithFrog = new Image(FileName.IMAGE_END_FROG, 74, 74, true, true);
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

  @Override
  public void act(long now) {
    // TODO Auto-generated method st
  }

  public boolean isActivated() {
    return activated;
  }
}
