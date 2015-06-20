import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by eugenew on 6/20/15.
 */
public class ValidInputChecker {
    private MyBufferedReader bufferedReader;
    private PrintStream printStream;
    private int input;

    public ValidInputChecker(MyBufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public int validInput() {
        if(input >= 1 && input <= 9){
            return input;
        } else {
            printStream.println("Invalid input");
            return 0;
        }
    }

    public void getInput() {
        String input = bufferedReader.readLine();
        this.input = Integer.parseInt(input);
    }

}
