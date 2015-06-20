import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Board board;
    private PrintStream printStream;

    @Before
    public void setUo(){
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        ticTacToe = new TicTacToe(board, printStream);
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
}
