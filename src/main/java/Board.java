import java.io.PrintStream;
import java.util.List;

/**
 * Created by eugenew on 6/20/15.
 */
public class Board {
    private PrintStream printStream;
    private List<String> locations;
    private final String unoccupied = " ";

    public Board(PrintStream printStream, List<String> locations) {
        this.locations = locations;
        for(int i = 0; i < 9; i++){
            locations.add(unoccupied);
        }

        this.printStream = printStream;
    }

    public void draw() {
        printStream.println("  |   |\n" +
                            "---------\n" +
                            "  |   |\n" +
                            "---------\n" +
                            "  |   |");
    }

    public void redraw(int location, String mark) {
        locations.set(location-1, mark);
        printStream.printf(" %s | %s | %s\n" +
                "---------\n" +
                " %s | %s | %s\n" +
                "---------\n" +
                " %s | %s | %s", locations.get(0), locations.get(1), locations.get(2), locations.get(3), locations.get(4), locations.get(5), locations.get(6), locations.get(7), locations.get(8));
    }
}
