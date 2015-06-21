import java.io.PrintStream;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToe {
    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;

    public TicTacToe(Board board, PrintStream printStream, Player playerOne, Player playerTwo) {
        this.board = board;
        this.printStream = printStream;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        board.draw();
        placeMarkOnBoard(playerOne);
        placeMarkOnBoard(playerTwo);
    }

    private void placeMarkOnBoard(Player player) {
        do{
            prompt();
        } while(!board.redraw(player.location(),player.mark()));
    }

    public void prompt() {
        printStream.println("Enter a number between 1 and 9:");
    }
}
