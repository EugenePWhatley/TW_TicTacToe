import java.io.PrintStream;
import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class BoardMarker {

    private Board board;
    private PrintStream printStream;

    BoardMarker(Board board, PrintStream printStream){

        this.board = board;
        this.printStream = printStream;
    }

    public void placeMarkOnBoard(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if (board.boardFull()) {
                printStream.println("\nGame Is Draw");
                break;
            }
            do {
                printStream.println("\nEnter a number between 1 and 9:");
            } while (!board.redraw(players.get(i).location(), players.get(i).mark()));
        }
    }
}
