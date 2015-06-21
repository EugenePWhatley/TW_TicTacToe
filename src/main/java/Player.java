import java.io.PrintStream;

/**
 * Created by eugenew on 6/20/15.
 */
public class Player {

    private String mark;
    private ValidInputChecker input;
    private PrintStream printStream;

    public Player(String mark, ValidInputChecker input, PrintStream printStream) {
        this.mark = mark;
        this.input = input;
        this.printStream = printStream;
    }

    public int move() {
        printStream.println("\nEnter a number between 1 and 9:");
        int location = input.validInput();
        return location-1;
    }


    public String mark() {
        return mark;
    }
}
