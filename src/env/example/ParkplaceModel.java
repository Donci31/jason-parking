package example;

import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;
import jason.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkplaceModel extends GridWorldModel {

    public static final int GridSize = 10;

    public static final int EXIT = 16;

    public static final int PARK_PLACE = 32;

    public static final int CAR = 64;

    private final Map<String, Pair<Integer, Integer>> parkPlaces = new HashMap<>();

    public ParkplaceModel() {
        super(GridSize, GridSize, 1);

        // Exit 1
        add(EXIT, new Location(0, 0));

        // Exit 2
        add(EXIT, new Location(GridSize - 1, GridSize - 1));
    }

    public void newParkPlace(String carId, int x, int y) {
        if (!parkPlaces.containsKey(carId)) {
            parkPlaces.put(carId, new Pair<>(x, y));
            add(PARK_PLACE, new Location(x, y));
            view.repaint();
        }
    }

    public void parkCar(String carId) {
        Pair<Integer, Integer> coord = parkPlaces.get(carId);
        int x = coord.getFirst();
        int y = coord.getSecond();

        remove(PARK_PLACE, new Location(x, y));
        add(CAR, new Location(x, y));
        view.repaint();
    }
}
