import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The {@code Game} class
 *
 * @author Mishima
 * @since 1.0.0
 */

public class Game
{
    public static final int TOP = 9999;
    public static final int BOTTOM = 1000;

    private static int step = 0;

    private Number generatedNumber;
    private Number userNumber;
    private Bull bull;
    private Cow cow;

    public Game()
    {
        System.out.println("Hello there! Welcome to bulls and cows console game!");

        bull = new Bull();
        cow = new Cow();
        generatedNumber = new Number(Integer
                .toString(ThreadLocalRandom
                        .current()
                        .nextInt(BOTTOM, TOP)));

        gameStart();
    }

    public void gameStart()
    {
        do
        {
            inputUserData();
            checkNumber();
        }
        while (generatedNumber.equals(userNumber));

        gameOver();
    }

    public void checkNumber()
    {
        //checking how many cows and bulls users number has
    }

    public void inputUserData()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            userNumber = new Number(reader.readLine());
        }
        catch (IOException e) {}
    }

    public void gameOver()
    {
        System.out.println("Results");
        System.out.print("Step: " + step);
        System.out.print("\tBulls: " + bull.getState());
        System.out.print("\tCows: " + cow.getState());
    }
}
