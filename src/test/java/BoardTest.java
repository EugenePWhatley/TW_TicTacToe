import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/20/15.
 */
public class BoardTest {

    @Test
    public void shouldDrawBoardWhenAsked(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.draw();

        verify(printStream).println("  |   |\n" +
                                    "---------\n" +
                                    "  |   |\n" +
                                    "---------\n" +
                                    "  |   |");
    }
}
