import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import jason.architecture.*;
import jason.asSemantics.ActionExec;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;

import javax.swing.*;

public class Car3GUI extends AgArch {

    JFrame    f;
    JButton auction;
    JTextField input;

    int auctionID = 0;
    int exit = 0;

    public Car3GUI() {
        auction = new JButton("Start new auction");
        input = new JTextField(1);
        auction.addActionListener(e -> {
            try {
                exit = Integer.parseInt(input.getText());
            } catch(NumberFormatException ex) {
                exit = -1;
            }

            if (1 > exit || 8 < exit) {
                return;
            }
            Literal goal = Literal.parseLiteral("start_auction(" + auctionID++ + "," + exit + ")");
            getTS().getC().addAchvGoal(goal, null);
        });

        f = new JFrame("Car 3 agent");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(BorderLayout.NORTH, input);
        f.getContentPane().add(BorderLayout.CENTER, auction);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void stop() {
        f.dispose();
        super.stop();
    }
}
