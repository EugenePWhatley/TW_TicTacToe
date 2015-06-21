import java.io.PrintStream;
import java.util.List;

import static java.lang.String.format;

/**
 * Created by eugenew on 6/20/15.
 */
public class Board {
    private final String unoccupied = " ";
    private PrintStream printStream;
    private List<String> cells;

    public Board(PrintStream printStream, List<String> cells) {
        this.cells = cells;
        this.printStream = printStream;
    }

    public void draw() {
        String boardGrid = format(
                "%s|%s|%s\n" +
                        "------\n" +
                        "%s|%s|%s\n" +
                        "------\n" +
                        "%s|%s|%s",
                cells.toArray());
        printStream.println(boardGrid);
    }

    public void mark(int location, String mark) {
        cells.set(location, mark);
    }

    public boolean isLocationAvailable(int location) {
        if (cells.get(location).equals(unoccupied)) {
            return true;
        }
        printStream.println("Location already filled");
        return false;
    }

    public boolean boardFull() {
        for (String location : cells) {
            if (location.equals(unoccupied)) {
                return false;
            }
        }
        return true;
    }

    public List<String> cells() {
        return cells;
    }
}
