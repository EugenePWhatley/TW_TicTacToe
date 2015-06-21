import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by eugenew on 6/20/15.
 */
public class GameRefTest {

    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;
    private GameRef gameRef;

    @Before
    public void setUp()  {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        List<Player> players = Arrays.asList(playerOne, playerTwo);
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
        when(playerOne.move()).thenReturn(1);
        when(playerOne.mark()).thenReturn("X");
        when(board.boardFull()).thenReturn(false).thenReturn(true);
        when(board.isLocationAvailable(1)).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(board).mark(1,"X");
    }

    @Test
    public void shouldAskPlayerToInputAnotherPositionWhenLocationIsNotAvailable(){
        when(playerOne.move()).thenReturn(1);
        when(playerOne.mark()).thenReturn("X");
        when(board.boardFull()).thenReturn(false).thenReturn(true);
        when(board.isLocationAvailable(1)).thenReturn(false).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(playerOne, times(2)).move();
    }

    @Test
    public void shouldAskPlayerTwoToInputPositionWhenPlayerOneFinishesTurn(){
        when(playerOne.move()).thenReturn(1);
        when(playerOne.mark()).thenReturn("X");
        when(playerTwo.move()).thenReturn(2);
        when(playerTwo.mark()).thenReturn("O");
        when(board.boardFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        when(board.isLocationAvailable(1)).thenReturn(true);
        when(board.isLocationAvailable(2)).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(playerTwo).move();
    }

    @Test
    public void shouldDrawBoardWhenPlayerMakesValidMove(){
        when(playerOne.move()).thenReturn(1);
        when(playerOne.mark()).thenReturn("X");
        when(board.boardFull()).thenReturn(false).thenReturn(true);
        when(board.isLocationAvailable(1)).thenReturn(true);

        gameRef.placeMarkOnBoard();

        verify(board).draw();
    }

    @Test
    public void shouldAcknowledgePlayerOneAsWinnerWhenPlayerOneHasMarkOnTopRow() {

        gameRef.determineWinner();

        verify(printStream).println(contains("Player 1 Wins"));
    }


}