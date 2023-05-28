package example;

import jason.asSyntax.*;
import jason.environment.*;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Env extends Environment {
    private final ParkingGUI gui = new ParkingGUI();

    ParkplaceModel model;

    @Override
    public void init(String[] args) {
        model = new ParkplaceModel();
        ParkplaceView view = new ParkplaceView(model);
        model.setView(view);
    }

    /* a simple GUI */
    class ParkingGUI extends JFrame {
        JButton newCar1;
        JButton newCar2;
        JButton newParkPlace;

        Random random = new Random();

        int agents = 0;

        ParkingGUI() {
            super("Control panel");
            newCar1 = new JButton("New Car (exit at 1)");
            newCar2 = new JButton("New Car (exit at 2)");
            newParkPlace = new JButton("New Park Place");

            newParkPlace.addActionListener(e -> {
                try {
                    String agentName = getEnvironmentInfraTier().getRuntimeServices().createAgent(
                            "park_place_" + agents, // agent name
                            "park_place.asl", // AgentSpeak source
                            null, // default agent class
                            null, // default architecture class
                            null,
                            null, null); // default settings
                    getEnvironmentInfraTier().getRuntimeServices().startAgent(agentName);

                    int x = random.nextInt(10);
                    int y = random.nextInt(10);

                    model.newParkPlace("park_place_" + agents++, x, y);

                    Literal belief = Literal.parseLiteral("distance_to_exit(1, " + (int) Math.sqrt(Math.pow((x), 2) + Math.pow((y), 2)) + ")");
                    Literal belief2 = Literal.parseLiteral("distance_to_exit(2, " + (int) Math.sqrt(Math.pow((10 - x), 2) + Math.pow((10 - y), 2)) + ")");
                    addPercept(agentName, belief);
                    addPercept(agentName, belief2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            newCar1.addActionListener(e -> {
                try {
                    String agentName = getEnvironmentInfraTier().getRuntimeServices().createAgent(
                            "car", // agent name
                            "car.asl", // AgentSpeak source
                            null, // default agent class
                            null, // default architecture class
                            null, // default belief base parameters
                            null, null); // default settings
                    getEnvironmentInfraTier().getRuntimeServices().startAgent(agentName);
                    int wants_to_exit_at = 1;
                    Literal belief = Literal.parseLiteral("wants_to_exit_at(" + wants_to_exit_at + ")");
                    addPercept(agentName, belief);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            newCar2.addActionListener(e -> {
                try {
                    String agentName = getEnvironmentInfraTier().getRuntimeServices().createAgent(
                            "car", // agent name
                            "car.asl", // AgentSpeak source
                            null, // default agent class
                            null, // default architecture class
                            null, // default belief base parameters
                            null, null); // default settings
                    getEnvironmentInfraTier().getRuntimeServices().startAgent(agentName);
                    int wants_to_exit_at = 2;
                    Literal belief = Literal.parseLiteral("wants_to_exit_at(" + wants_to_exit_at + ")");
                    addPercept(agentName, belief);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            getContentPane().setLayout(new BorderLayout());
            // getContentPane().add(BorderLayout.NORTH, input);
            getContentPane().add(BorderLayout.SOUTH, newParkPlace);
            getContentPane().add(BorderLayout.CENTER, newCar1);
            getContentPane().add(BorderLayout.EAST, newCar2);
            pack();
            setVisible(true);
        }
    }

    @Override
    public boolean executeAction(String ag, Structure action) {
        if (action.getFunctor().equals("parked")) {
            String carId = action.getTerm(0).toString();
            model.parkCar(carId);
        }
        return true;
    }

    @Override
    public void stop() {
        super.stop();
        gui.setVisible(false);
    }
}
