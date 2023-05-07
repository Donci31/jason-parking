import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;

import javax.swing.*;

public class AuctioneerGUI extends AgArch {

    JFrame    f;
    JButton auction;
    JTextField input;

    int exit = 0;

    public AuctioneerGUI() {
        auction = new JButton("Start new auction");
        input = new JTextField(1);
        auction.addActionListener(e -> {
            try {
                exit = Integer.parseInt(input.getText());
            } catch(NumberFormatException ex) {
                exit = 0;
            }
            Literal goal = ASSyntax.createLiteral("start_auction", ASSyntax.createNumber(exit));
            getTS().getC().addAchvGoal(goal, null);
        });

        f = new JFrame("Auctioneer agent");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(BorderLayout.NORTH, input);
        f.getContentPane().add(BorderLayout.CENTER, auction);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void act(ActionExec action) {
        super.act(action);
    }

    @Override
    public void stop() {
        f.dispose();
        super.stop();
    }
}
