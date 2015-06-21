import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

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
        when(board.isLocationAvailable(1)).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(board).mark(1,"X");
    }

    @Test
    public void shouldAskPlayerToInputAnotherPositionWhenLocationIsNotAvailable(){
        when(players.get(0).move()).thenReturn(1);
        when(players.get(0).mark()).thenReturn("X");
        when(board.boardFull()).thenReturn(false).thenReturn(true);
        when(board.isLocationAvailable(1)).thenReturn(false).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(playerOne, times(2)).move();
    }

    @Test
    public void shouldAskPlayerTwoToInputPositionWhenPlayerOneFinishesTurn(){
        when(players.get(0).move()).thenReturn(1);
        when(players.get(0).mark()).thenReturn("X");
        when(players.get(1).move()).thenReturn(2);
        when(players.get(1).mark()).thenReturn("O");
        when(board.boardFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        when(board.isLocationAvailable(1)).thenReturn(true);
        when(board.isLocationAvailable(2)).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(playerTwo).move();
    }

    @Test
    public void shouldDrawBoardWhenPlayerMakesValidMove(){
        when(players.get(0).move()).thenReturn(1);
        when(players.get(0).mark()).thenReturn("X");
        when(board.boardFull()).thenReturn(false).thenReturn(true);
        when(board.isLocationAvailable(1)).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(board).draw();

    }
}