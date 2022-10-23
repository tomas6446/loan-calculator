package org.calculator.draw;

import org.calculator.loan.Loan;
import org.calculator.loan.Table;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomas Kozakas
 */
public class Window extends JFrame {
    public Window(Loan loan, String title) {
        List<Integer> list = new ArrayList<>();
        for (Table table : loan.getFullTable()) {
            list.add((int) table.payment());
        }

        Graph panel = new Graph(list);

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
