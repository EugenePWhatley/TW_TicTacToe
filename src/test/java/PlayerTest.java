import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/20/15.
 */
public class PlayerTest {

    private Player player;
    private ValidInputChecker input;

    @Before
    public void setUp(){
        input = mock(ValidInputChecker.class);
        String mark = "X";
        player = new Player(mark, input);
    }

    @Test
    public void shouldGiveLocationOne()  {
        when(input.validInput()).thenReturn(1);
        assertEquals(1, player.location());
    }
    
}