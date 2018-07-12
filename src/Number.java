import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * The {@code Number} class
 * implements the number which generated
 * by computer or entered by user. Each number consists
 * of {@code NUMBER_SIZE} digits.
 *
 * @author Michael Sedov
 * @since 1.0.0
 */

public class Number
{
    public static final int NUMBER_SIZE = 4;

    private ArrayList<Integer> number = new ArrayList<>();

    public Number() {}

    public Number(String number)
    {
        for (int i = 0; i < NUMBER_SIZE; i++)
        {
            this.number.add(number.charAt(i) - '0');
        }
    }

    public void generateNumber()
    {
        Random rand = new Random();

        number.add(0, rand.nextInt(10));

        for (int i = 1; i < NUMBER_SIZE; i++)
        {
            rand = new Random();
            number.add(i, rand.nextInt(10));

            for (int j = 0; j < number.size() - 1; j++)
            {
                if (number.get(i).equals(number.get(j)))
                {
                    number.remove(i);
                    --i;
                }
            }
        }
    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Number: " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
