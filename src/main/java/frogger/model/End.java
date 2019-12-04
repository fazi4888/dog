package frogger.model;

import javafx.scene.image.Image;

public class End extends Actor {
  boolean activated = false;

  public End(int xpos, int ypos) {
    super("/frogger/image/end/End.png", xpos, ypos, 74, 74);
  }

  public void setEnd() {
    setImage(new Image("/frogger/image/end/FrogEnd.png", 74, 74, true, true));
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
