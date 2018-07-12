/**
 * The {@code AbstractAnimal} class
 * implements the logic of animal.
 * Each animal (bull and cow) has its own
 * state which shows how many number user guessed
 *
 * @author Michael Sedov
 * @version 1.0.0
 */

public abstract class AbstractAnimal
{
    protected int state;

    public abstract void setState(int state);

    public abstract int getState();
}
