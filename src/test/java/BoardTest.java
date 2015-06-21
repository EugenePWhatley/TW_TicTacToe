import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/20/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private Player player;
    private List<String> locations;
    private final String unoccupied = " ";

    @Before
    public void setUo(){
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        locations = new ArrayList<String>();
        board = new Board(printStream, locations);
    }

    @Test
    public void shouldDrawBoardWhenAsked(){
        board.draw();

        verify(printStream).println("  |   |\n" +
                                    "---------\n" +
                                    "  |   |\n" +
                                    "---------\n" +
                                    "  |   |");
    }

    @Test
    public void shouldRedrawBoardWithMarkInFirstLocation(){
        String mark = "X";
        board.redraw(1, mark);

        verify(printStream).printf("%s | %s | %s\n" +
                "---------\n" +
                "%s | %s | %s\n" +
                "---------\n" +
                "%s | %s | %s", mark, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied);
    }

    @Test
    public void shouldGiveErrorMessageForLocationAlreadyOccupied(){
        board.redraw(1, "X");
        board.redraw(1, "O");

        verify(printStream).println("Location already filled");
    }

    @Test
    public void shouldAcknowledgeFullBoard(){
        for (int i = 1; i <= 9; i++) {
            board.redraw(i, valueOf(i));
        }

        assertTrue(board.boardFull());
    }
}
