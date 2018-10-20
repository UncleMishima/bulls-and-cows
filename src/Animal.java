/**
 * The {@code AbstractAnimal} class
 * implements the logic of animal.
 * Each animal (bull and cow) has its own
 * state which shows how many number user guessed
 *
 * @author Michael Sedov
 * @version 1.0.0
 */

public class Animal {
    private int state;

    public Animal() {
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
