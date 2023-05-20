package example;

import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class ParkplaceModel extends GridWorldModel {

    public static final int GSize = 10;

    public static final int EXIT = 16;

    public static final int PARK_PLACE = 32;

    public ParkplaceModel() {
        super(GSize, GSize, 1);

        // Exit 1
        add(EXIT, new Location(0, 0));

        // Exit 2
        add(EXIT, new Location(GSize - 1, GSize - 1));
    }

    public void newParkPlace(int x, int y) {
        add(PARK_PLACE, new Location(x, y));
        view.repaint();
    }
}
