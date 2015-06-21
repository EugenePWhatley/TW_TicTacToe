import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/20/15.
 */
public class GameRefTest {

    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;
    private List<Player> players;
    private GameRef gameRef;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        players = Arrays.asList(playerOne, playerTwo);
        gameRef = new GameRef(board, printStream, players);
    }

    @Test
    public void shouldAcknowledgeADrawWhenBoardIsFull(){
        when(board.boardFull()).thenReturn(true);
        gameRef.placeMarkOnBoard();

        verify(printStream).println("\nGame Is Draw");
    }

    @Test
    public void shouldPlaceMarkInPositionOneWhenBoardIsNotFull(){
        when(players.get(0).move()).thenReturn(1);
        when(players.get(0).mark()).thenReturn("X");
        when(board.boardFull()).thenReturn(false).thenReturn(true);

        gameRef.placeMarkOnBoard();

        assertTrue(board.isLocationAvailable(1));
    }
}