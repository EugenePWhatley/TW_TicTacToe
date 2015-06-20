import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/20/15.
 */
public class ValidInputCheckerTest {

    private MyBufferedReader bufferedReader;
    private PrintStream printStream;
    private ValidInputChecker input;

    @Before
    public void setUp(){

        bufferedReader = mock(MyBufferedReader.class);
        printStream = mock(PrintStream.class);
        input = new ValidInputChecker(bufferedReader, printStream);
    }

    @Test
    public void shouldAcknowledgeInputWhenValid(){
        when(bufferedReader.readLine()).thenReturn("1");
        input.getInput();

        assertEquals(input.validInput(), 1);
    }

    @Test
    public void shouldGiveErrorMessageForInvalidInput(){
        when(bufferedReader.readLine()).thenReturn("20");
        input.getInput();
        input.validInput();

        verify(printStream).println("Invalid input");
    }

}
