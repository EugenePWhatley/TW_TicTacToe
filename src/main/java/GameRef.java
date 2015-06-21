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
            printStream.print("Player " + valueOf(i + 1));
            int move = players.get(i).move();
            String mark = players.get(i).mark();
            boolean inValidLocation = true;
            while (inValidLocation){
                if(board.isLocationAvailable(move)) {
                    board.mark(move, mark);
                    inValidLocation = false;
                } else {
                    move = players.get(i).move();
                    inValidLocation = true;
                }
            }
            board.draw();
        }
    }
}
