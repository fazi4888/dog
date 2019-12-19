package frogger.model.actor;

/**
 * A class implements the {@code Transformable} interface to implements {@link #transform(long
 * now)} transform the state of the actor.
 */
public interface Transformable {
  void transform(long now);
}
