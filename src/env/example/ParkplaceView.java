package example;

import jason.environment.grid.GridWorldView;

import java.awt.*;

public class ParkplaceView extends GridWorldView {

    public ParkplaceView(ParkplaceModel model) {
        super(model, "Garage", 700);
        defaultFont = new Font("Arial", Font.BOLD, 16);
        setVisible(true);
    }

    @Override
    public void draw(Graphics g, int x, int y, int object) {
        switch (object) {
            case ParkplaceModel.EXIT -> {
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "Exit");
            }
            case ParkplaceModel.PARK_PLACE -> {
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "Parking");
            }

            case ParkplaceModel.CAR -> {
                g.setColor(Color.black);
                drawString(g, x, y, defaultFont, "Car");
            }
        }
    }
}
