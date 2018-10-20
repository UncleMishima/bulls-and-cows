/**
 * The {@code Animal} class
 * implements the logic of animal.
 * Each animal (bull and cow) has its own
 * animalState which shows how many number user guessed
 *
 * @author Michael Sedov
 * @version 1.0.0
 */

public class Animal {
    private int animalState;

    public Animal() {
    }

    public void setAnimalState(int animalState) {
        this.animalState = animalState;
    }

    public int getAnimalState() {
        return animalState;
    }
}
