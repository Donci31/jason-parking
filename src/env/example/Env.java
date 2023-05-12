import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import java.util.*;
import jason.bb.*;
import jason.mas2j.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Env extends Environment {
	private ParkingGUI gui = new ParkingGUI();

	/* a simple GUI */
	class ParkingGUI extends JFrame {
		JButton newCar1;
		JButton newCar2;
		JButton newParkPlace;

		Random random = new Random();

		ParkingGUI() {
			super("Parking Garage");
			newCar1 = new JButton("New Car (exit at 1)");
			newCar2 = new JButton("New Car (exit at 2)");
			newParkPlace = new JButton("New Park Place");

			newParkPlace.addActionListener(e -> {
				try {
					String agentName = getEnvironmentInfraTier().getRuntimeServices().createAgent(
							"park_place", // agent name
							"park_place.asl", // AgentSpeak source
							null, // default agent class
							null, // default architecture class
							null,
							null, null); // default settings
					getEnvironmentInfraTier().getRuntimeServices().startAgent(agentName);
					Literal belief = Literal.parseLiteral("distance_to_exit(1, " + (random.nextInt(100) + 1) + ")");
					Literal belief2 = Literal.parseLiteral("distance_to_exit(2, " + (random.nextInt(100) + 1) + ")");
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
			paint();
		}

		void paint() {

		}
	}

	@Override
	public void stop() {
		super.stop();
		gui.setVisible(false);
	}
}
