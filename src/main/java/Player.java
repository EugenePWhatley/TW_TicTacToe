import java.io.PrintStream;

/**
 * Created by eugenew on 6/20/15.
 */
public class Player {

    private String mark;
    private ValidInputChecker input;
    private PrintStream printStream;
    private String number;

    public Player(String mark, ValidInputChecker input, PrintStream printStream, String number) {
        this.mark = mark;
        this.input = input;
        this.printStream = printStream;
        this.number = number;
    }

    public int move() {
        printStream.println("\nPlayer " + number + " Enter a number between 1 and 9:");
        int location = input.validInput();
        return location - 1;
    }


    public String mark() {
        return mark;
    }

}
