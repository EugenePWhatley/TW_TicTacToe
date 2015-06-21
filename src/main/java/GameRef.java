import java.io.PrintStream;
import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class GameRef {

    private Board board;
    private PrintStream printStream;
    private List<Player> players;

    public GameRef(Board board, PrintStream printStream, List<Player> players) {
        this.board = board;
        this.printStream = printStream;
        this.players = players;
    }

    public void placeMarkOnBoard() {
        for (Player player : players) {

            if (board.boardFull()) {
                printStream.println("\nGame Is Draw");
                return;
            }

            int move = getValidMove(player);
//          int move = new ValidMoveGetter().get();
//          move = getValidMove(player);
            board.mark(move, player.mark());

            board.draw();
        }
    }

    private int getValidMove(Player player) {
        printStream.print("Player " + player.number());
        int move = player.move();
        boolean invalidLocation = true;
        while (invalidLocation) {
            if (board.isLocationAvailable(move)) {
                invalidLocation = false;
            } else {
                move = player.move();
                invalidLocation = true;
            }
        }
        return move;
    }

    public boolean determineWinner() {
        if (board.cells().get(0).equals("X") && board.cells().get(1).equals("X") && board.cells().get(2).equals("X")) {
            printStream.println("Player 1 Wins!");
            return true;
        }
        return false;
    }
}
