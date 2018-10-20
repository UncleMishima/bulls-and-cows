/**
 * The {@code Cow} class
 *
 * @author Michael Sedov
 * @since 1.0.0
 */


public class Cow extends AbstractAnimal {
    @Override
    public void setState(int state)
    {
        this.state = state;
    }

    @Override
    public int getState()
    {
        return state;
    }
}
