import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToe {
    private Board board;
    private List<Player> players;
    private GameRef gameRef;

    public TicTacToe(Board board, List<Player> players, GameRef gameRef) {
        this.board = board;
        this.players = players;
        this.gameRef = gameRef;
    }

    public void start() {
        board.draw();
        while (!board.boardFull()) {
            gameRef.placeMarkOnBoard(players);
        }
    }
}
