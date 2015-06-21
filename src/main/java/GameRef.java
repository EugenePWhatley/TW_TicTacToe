import java.io.PrintStream;
import java.util.List;

import static java.lang.String.valueOf;

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
            int move = players.get(i).move();
            String mark = players.get(i).mark();
            while (board.isLocationAvailable(move)) {
                board.mark(move,mark);
            }
            board.draw();
        }
    }
}
