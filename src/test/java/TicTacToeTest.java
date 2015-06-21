import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUo(){
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        ticTacToe = new TicTacToe(board, printStream, playerOne, playerTwo);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts(){
        ticTacToe.start();

        verify(board).draw();
    }

    @Test
    public void shouldPromptPlayerToMakeMoveAfterBoardDrawn(){
        ticTacToe.prompt();

        verify(printStream).println("Enter a number between 1 and 9:");
    }

    @Test
    public void shouldPlacePlayersMoveOnBoard(){
        when(playerOne.location()).thenReturn(2);
        when(playerOne.mark()).thenReturn("X");

        ticTacToe.start();

        verify(board).redraw(playerOne.location(), playerOne.mark());
    }

    @Test
    public void shouldPlacePlayerTwoMoveOnBoardWithPlayerOnesMove(){
        when(playerOne.location()).thenReturn(2);
        when(playerOne.mark()).thenReturn("X");
        when(playerTwo.location()).thenReturn(3);
        when(playerTwo.mark()).thenReturn("O");

        ticTacToe.start();

        verify(board).redraw(playerOne.location(), playerOne.mark());
        verify(board).redraw(playerTwo.location(), playerTwo.mark());
    }
}
