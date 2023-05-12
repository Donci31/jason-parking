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

	/** world model */
	private boolean[][] dirty = { { true, true }, // all dirty
			{ true, true }
	};

	private int vcx = 0; // the vacuum cleaner location
	private int vcy = 0;

	private Object modelLock = new Object();

	/** general delegations */
	private ParkingGUI gui = new ParkingGUI();
	private Logger logger = Logger.getLogger("env." + Env.class.getName());

	/** constant terms used for perception */
	private static final Literal lPos1 = ASSyntax.createLiteral("pos", ASSyntax.createNumber(1));
	private static final Literal lPos2 = ASSyntax.createLiteral("pos", ASSyntax.createNumber(2));
	private static final Literal lPos3 = ASSyntax.createLiteral("pos", ASSyntax.createNumber(3));
	private static final Literal lPos4 = ASSyntax.createLiteral("pos", ASSyntax.createNumber(4));
	private static final Literal lDirty = ASSyntax.createLiteral("dirty");
	private static final Literal lClean = ASSyntax.createLiteral("clean");

	public Env() {
	}

	@Override
	public boolean executeAction(String ag, Structure action) {
		logger.info("doing " + action);

		try {
			Thread.sleep(500); // slow down the execution
		} catch (Exception e) {
		}

		synchronized (modelLock) {
			// Change the world model based on action
			if (action.getFunctor().equals("suck")) {
				if (dirty[vcx][vcy]) {
					dirty[vcx][vcy] = false;
				} else {
					logger.info("suck in a clean location!");
					Toolkit.getDefaultToolkit().beep();
				}
			} else if (action.getFunctor().equals("left")) {
				if (vcx > 0) {
					vcx--;
				}
			} else if (action.getFunctor().equals("right")) {
				if (vcx < 1) {
					vcx++;
				}
			} else if (action.getFunctor().equals("up")) {
				if (vcy > 0) {
					vcy--;
				}
			} else if (action.getFunctor().equals("down")) {
				if (vcy < 1) {
					vcy++;
				}
			} else {
				logger.info("The action " + action + " is not implemented!");
				return false;
			}
		}

		gui.paint();
		return true;
	}

	@Override
	public void stop() {
		super.stop();
		gui.setVisible(false);
	}

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
}
