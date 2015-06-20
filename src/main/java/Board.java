import java.io.PrintStream;

/**
 * Created by eugenew on 6/20/15.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void draw() {
        printStream.println("  |   |\n" +
                            "---------\n" +
                            "  |   |\n" +
                            "---------\n" +
                            "  |   |");
    }
}
