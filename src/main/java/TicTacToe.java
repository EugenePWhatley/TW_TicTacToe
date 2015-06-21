import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToe {
    private Board board;
    private List<Player> players;
    private BoardMarker boardMarker;

    public TicTacToe(Board board, List<Player> players, BoardMarker boardMarker) {
        this.board = board;
        this.players = players;
        this.boardMarker = boardMarker;
    }

    public void start() {
        board.draw();
        while (!board.boardFull()) {
            boardMarker.placeMarkOnBoard(players);
        }
    }
}
