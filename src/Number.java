import java.util.Objects;

/**
 * The {@code Number} class
 *
 * @author Mishima
 * @since 1.0.0
 */

public class Number
{
    public static final int NUMBER_SIZE = 4;

    private final int number;

    public Number(String number)
    {
        this.number = Integer.parseInt(number);
    }

    int getNumber()
    {
        return number;
    }

    @Override
    public String toString() {
        return "Number: " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
