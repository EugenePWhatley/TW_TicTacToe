import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class Main {
    public static void main(String[] args) {
        MyBufferedReader bufferedReader = new MyBufferedReader(new InputStreamReader(System.in));
        ValidInputChecker input = new ValidInputChecker(bufferedReader);
        Player playerOne = new Player("X", input);
        Player playerTwo = new Player("O", input);
        List<Player> players = new ArrayList<Player>();
        players.add(playerOne);
        players.add(playerTwo);
        ArrayList<String> locations = new ArrayList<String>();
        Board board = new Board(System.out, locations);
        GameRef gameRef = new GameRef(board,System.out);
        new TicTacToe(board, players, gameRef).start();
    }
}
