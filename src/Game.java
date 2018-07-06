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

        System.out.println("Computer number is: " + generatedNumber);

        gameStart();
    }

    public void gameStart()
    {
        do
        {
            ++step;
            inputUserData();
            checkNumber();
            printResult();
        }
        while (!generatedNumber.equals(userNumber));

        printResult();
    }

    public void checkNumber()
    {
        if (generatedNumber.equals(userNumber)) return;

        int bullState = 0;
        int cowState = 0;

        int[] genNumber = Integer.toString(generatedNumber
                .getNumber())
                .chars()
                .map(c -> c-'0')
                .toArray();

        int[] userNumber = Integer.toString(this.userNumber
                .getNumber())
                .chars()
                .map(c -> c-'0')
                .toArray();

        for (int i = 0; i < Number.NUMBER_SIZE; i++)
        {
            if (genNumber[i] == userNumber[i]) ++bullState;
            else
            {
                for (int j = 0; j < Number.NUMBER_SIZE; j++)
                {
                    if (genNumber[i] == userNumber[j]) ++cowState;
                }
            }
        }

        bull.setState(bullState);
        cow.setState(cowState);
    }

    public void inputUserData()
    {
        System.out.println();

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            userNumber = new Number(reader.readLine());
        }
        catch (IOException e) {}
    }

    public void printResult()
    {
        System.out.println("Results");
        System.out.print("Step: " + step);
        System.out.print("\tBulls: " + bull.getState());
        System.out.print("\tCows: " + cow.getState());
    }
}
