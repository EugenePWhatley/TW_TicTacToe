import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Board board;
    private GameRef gameRef;

    @Before
    public void setUo(){
        board = mock(Board.class);
        gameRef = mock(GameRef.class);
        ticTacToe = new TicTacToe(board, gameRef);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts(){
        ticTacToe.start();

        verify(board).draw();
    }

    @Test
    public void shouldNotTellRefToPlaceMarkOnBoardWhenBoardIsFull(){
        when(board.boardFull()).thenReturn(true);

        ticTacToe.start();

        verify(gameRef, never()).placeMarkOnBoard();
    }

    @Test
    public void shouldTellRefToPlaceMarkOnBoardWhenBoardIsNotFull(){
        when(board.boardFull()).thenReturn(false);

        ticTacToe.start();

        verify(gameRef).placeMarkOnBoard();
    }
}
