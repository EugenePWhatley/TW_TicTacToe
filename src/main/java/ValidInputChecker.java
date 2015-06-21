import static java.lang.Integer.parseInt;

/**
 * Created by eugenew on 6/20/15.
 */
public class ValidInputChecker {
    private MyBufferedReader bufferedReader;
    private int input;

    public ValidInputChecker(MyBufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int validInput() {
        String inputAsString = bufferedReader.readLine();
        this.input = parseInt(inputAsString);
        if (input >= 1 && input <= 9) {
            return input;
        } else {
            return 0;
        }
    }


}
