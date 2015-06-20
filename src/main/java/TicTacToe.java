import java.io.PrintStream;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToe {
    private Board board;
    private PrintStream printStream;

    public TicTacToe(Board board, PrintStream printStream) {
        this.board = board;
        this.printStream = printStream;
    }

    public void start() {
        board.draw();
        prompt();
    }

    public void prompt() {
        printStream.println("Enter a number between 1 and 9:");
    }
}
