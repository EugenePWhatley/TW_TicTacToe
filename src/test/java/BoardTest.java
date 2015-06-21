import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.valueOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/20/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private Player player;
    private List<String> cells;
    private final String unoccupied = " ";

    @Before
    public void setUo(){
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        cells = Arrays.asList(
                unoccupied,unoccupied,unoccupied,
                unoccupied,unoccupied,unoccupied,
                unoccupied,unoccupied,unoccupied);
        board = new Board(printStream, cells);
    }

    @Test
    public void shouldPrintGridWhenDrawn(){
        board.draw();

        verify(printStream).println(" | | \n" +
                                    "------\n" +
                                    " | | \n" +
                                    "------\n" +
                                    " | | ");
    }

    @Test
    public void shouldRedrawBoardWithMarkInFirstLocation(){
        String mark = "X";
        board.mark(1, mark);

        assertThat(cells.get(0), is(mark));
    }

    @Test
    public void shouldGiveErrorMessageForLocationAlreadyOccupied(){
        board.mark(1, "X");

        board.isLocationAvailable(1);

        verify(printStream).println("Location already filled");
    }

    @Test
    public void shouldAcknowledgeFullBoard(){
        for (int i = 1; i <= 9; i++) {
            board.mark(i, valueOf(i));
        }

        assertTrue(board.boardFull());
    }
}
