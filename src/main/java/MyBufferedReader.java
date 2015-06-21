import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by eugenew on 6/20/15.
 */
public class MyBufferedReader extends BufferedReader {
    public MyBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
