import java.util.ArrayList;

/**
 * Created by eugenew on 6/20/15.
 */
public class Main {
    public static void main(String[] args) {
        new TicTacToe(new Board(System.out, new ArrayList<String>()),System.out).start();
    }
}
