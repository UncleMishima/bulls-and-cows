/**
 * The {@code Bull} class
 *
 * @author Michael Sedov
 * @since 1.0.0
 */

public class Bull extends AbstractAnimal
{
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
