
/**
 * Created by eugenew on 6/20/15.
 */
public class Player {

    private String mark;
    private ValidInputChecker input;

    public Player(String mark, ValidInputChecker input) {
        this.mark = mark;
        this.input = input;
    }

    public int move() {
        int location = input.validInput();
        return location;
    }


    public String mark() {
        return mark;
    }
}
