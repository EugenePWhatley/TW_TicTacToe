import java.io.PrintStream;
import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class GameRef {

    private Board board;
    private PrintStream printStream;
    private List<Player> players;

    public GameRef(Board board, PrintStream printStream, List<Player> players){
        this.board = board;
        this.printStream = printStream;
        this.players = players;
    }

    public void placeMarkOnBoard() {
        for (int i = 0; i < players.size(); i++) {
            if (board.boardFull()) {
                printStream.println("\nGame Is Draw");
                break;
            }
            do {
                printStream.println("\nEnter a number between 1 and 9:");
            } while (!board.mark(players.get(i).move(), players.get(i).mark()));
            board.draw();
        }
    }
}
