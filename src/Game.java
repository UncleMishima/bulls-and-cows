import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The {@code Game} class
 * implements logic of the game
 *
 * @author Michael Sedov
 * @since 1.0.0
 */

public class Game
{
    private static int step = 0;

    private final Number generatedNumber;
    private Number userNumber;
    private Bull bull;
    private Cow cow;

    public Game()
    {
        bull = new Bull();
        cow = new Cow();

        generatedNumber = new Number();
        generatedNumber.generateNumber();

        System.out.println("Computer number is: " + generatedNumber.toString());

        gameStart();
    }

    public void gameStart()
    {
        System.out.println("---------Hello there! Welcome to bulls and cows console game!---------");

        do
        {
            ++step;
            bull.setState(0);
            cow.setState(0);
            inputUserData();
            checkNumber();
            printResult();
        }
        while (!generatedNumber.equals(userNumber));

        System.out.println("Congratulations! You guessed the number "
                + generatedNumber + " for "
                + step + " steps!");

        System.out.println("----------------------------------------------------------------------");
    }

    public void checkNumber()
    {
        if (generatedNumber.equals(userNumber))
        {
            bull.setState(4);
            return;
        }

        int bullState = 0;
        int cowState = 0;

        final ArrayList<Integer> genNumber = generatedNumber.getNumber();
        final ArrayList<Integer> usrNumber = userNumber.getNumber();

        for (int i = 0; i < Number.NUMBER_SIZE; i++)
        {
            if (genNumber.get(i).equals(usrNumber.get(i))) ++bullState;
            else
            {
                for (int j = 0; j < Number.NUMBER_SIZE; j++)
                {
                    if (genNumber.get(i).equals(usrNumber.get(j))) ++cowState;
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
            System.out.print("Enter your Number: ");
            userNumber = new Number(reader.readLine());
        }
        catch (IOException e) {}
    }

    public void printResult()
    {
        System.out.print("Step: " + step);
        System.out.print("\tBulls: " + bull.getState());
        System.out.println("\tCows: " + cow.getState());
    }
}
