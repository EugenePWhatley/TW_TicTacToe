import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/20/15.
 */
public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<Player> players;
    private GameRef gameRef;

    @Before
    public void setUo(){
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        players = new ArrayList<Player>();
        players.add(playerOne);
        players.add(playerTwo);
        gameRef = mock(GameRef.class);
        ticTacToe = new TicTacToe(board, gameRef);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts(){
        ticTacToe.start();

        verify(board).draw();
    }

    @Test
    public void shouldPlacePlayersMoveOnBoard(){
        when(playerOne.move()).thenReturn(2);
        when(playerOne.mark()).thenReturn("X");

        ticTacToe.start();

        verify(board).mark(playerOne.move(), playerOne.mark());
    }

    @Test
    public void shouldPlacePlayerTwoMoveOnBoardWithPlayerOnesMove(){
        when(playerOne.move()).thenReturn(2);
        when(playerOne.mark()).thenReturn("X");
        when(playerTwo.move()).thenReturn(3);
        when(playerTwo.mark()).thenReturn("O");

        ticTacToe.start();

        verify(board).mark(playerOne.move(), playerOne.mark());
        verify(board).mark(playerTwo.move(), playerTwo.mark());
    }
}
