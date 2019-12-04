package frogger.model;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView {

  public Actor(String imageLink, int xpos, int ypos, int width, int height) {
    setImage(new Image(imageLink, width, height, true, true));
    setX(xpos);
    setY(ypos);
  }

  public void move(double dx, double dy) {
    setX(getX() + dx);
    setY(getY() + dy);
  }

  public double getWidth() {
    return this.getBoundsInLocal().getWidth();
  }

  public double getHeight() {
    return this.getBoundsInLocal().getHeight();
  }

  private AnimationTimer timer =
      new AnimationTimer() {
        @Override
        public void handle(long now) {
          act(now);
        }
      };

  public void run() {
    timer.start();
  }

  public void stop() {
    timer.stop();
  }

  public abstract void act(long now);
}