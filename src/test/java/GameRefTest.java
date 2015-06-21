import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/20/15.
 */
public class GameRefTest {

    @Test
    public void shouldAcknowledgeADraw(){
        Board board = mock(Board.class);
        PrintStream printStream = mock(PrintStream.class);
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);
        List<Player> players = new ArrayList<Player>();
        players.add(playerOne);
        players.add(playerTwo);
        GameRef gameRef = new GameRef(board, printStream, players);

        when(board.boardFull()).thenReturn(true);
        gameRef.placeMarkOnBoard();

        verify(printStream).println("\nGame Is Draw");
    }
}