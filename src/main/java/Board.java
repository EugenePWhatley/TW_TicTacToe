import java.io.PrintStream;
import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class Board {
    private PrintStream printStream;
    private List<String> cells;
    private final String unoccupied = " ";

    public Board(PrintStream printStream, List<String> cells) {
        this.cells = cells;
        this.printStream = printStream;
    }

    public void draw() {
        String boardGrid = String.format(
                "%s|%s|%s\n" +
                "------\n" +
                "%s|%s|%s\n" +
                "------\n" +
                "%s|%s|%s",
                cells.get(0), cells.get(1), cells.get(2),
                cells.get(3), cells.get(4), cells.get(5),
                cells.get(6), cells.get(7), cells.get(8));
        printStream.println(boardGrid);
    }

    public boolean mark(int location, String mark) {
        if(cells.get(location-1).equals(unoccupied)) {
            cells.set(location - 1, mark);
            return true;
        }
        printStream.println("Location already filled");
        return false;
    }

    public boolean boardFull(){
        for (String location : cells) {
            if(location.equals(unoccupied)){
                return false;
            }
        }
        return true;
    }
}
