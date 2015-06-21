
/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToe {
    private Board board;
    private GameRef gameRef;

    public TicTacToe(Board board,  GameRef gameRef) {
        this.board = board;
        this.gameRef = gameRef;
    }

    public void start() {
        board.draw();
        while (!board.boardFull()) {
            gameRef.placeMarkOnBoard();
        }
    }
}
