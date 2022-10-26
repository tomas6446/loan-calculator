package org.calculator.window;

import org.calculator.loan.Annuity;
import org.calculator.loan.Linear;
import org.calculator.loan.Postponement;
import org.calculator.window.companent.ComboBox;
import org.calculator.window.companent.Graph;
import org.calculator.window.companent.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Tomas Kozakas
 */
public class Window extends JFrame implements ActionListener {
    // create a frame
    private static JFrame jFrame;
    private static TextField balanceTextField;
    private static TextField percentTextField;
    private static TextField yearTextField;
    private static TextField monthTextField;
    private static TextField postStartMonth;
    private static TextField postPeriod;
    private static TextField postPercent;
    private static JButton jButton;
    private static ComboBox loanBox;
    private static ComboBox columnBox;
    private static JPanel inputPanel;
    private static JPanel postPonementPanel;
    private static Graph graphPanel;

    public Window() {
        inputPanel = new JPanel(new FlowLayout());
        graphPanel = new Graph(new Linear(10000, 15, 1, 0).getTable().getColumn("payment"));

        inputPanel.add(new TextField("Balance:", false));
        inputPanel.add(balanceTextField = new org.calculator.window.companent.TextField("10000", true));
        inputPanel.add(new TextField("Percent:", false));
        inputPanel.add(percentTextField = new org.calculator.window.companent.TextField("15", true));
        inputPanel.add(new TextField("Year:", false));
        inputPanel.add(yearTextField = new org.calculator.window.companent.TextField("1", true));
        inputPanel.add(new TextField("Month:", false));
        inputPanel.add(monthTextField = new TextField("0", true));
        inputPanel.add(loanBox = new ComboBox(new String[]{"Linear", "Annuity"}, "Annuity"));
        inputPanel.add(columnBox = new ComboBox(new String[]{"payment", "initial", "debt part", "balance left"}, "payment"));
        jButton = new JButton("OK");
        jButton.addActionListener(e -> {
            double balance = Double.parseDouble(balanceTextField.toString());
            double percent = Double.parseDouble(percentTextField.toString());
            int year = Integer.parseInt(yearTextField.toString());
            int month = Integer.parseInt(monthTextField.toString());

            int start = Integer.parseInt(postStartMonth.toString());
            int end = Integer.parseInt(postPeriod.toString());
            double percentPost = Double.parseDouble(postPercent.toString());
            Postponement postponement = new Postponement(start, end, percentPost);

            jFrame.remove(graphPanel);
            switch (loanBox.getChosenItem()) {
                case "Annuity" ->
                        graphPanel = new Graph(new Annuity(balance, percent, year, month, postponement).getTable().getColumn(columnBox.getChosenItem()));
                case "Linear" ->
                        graphPanel = new Graph(new Linear(balance, percent, year, month, postponement).getTable().getColumn(columnBox.getChosenItem()));
                default -> throw new IllegalStateException("Unexpected value: " + loanBox.getChosenItem());
            }
            jFrame.add(graphPanel);
            jFrame.validate();
            jFrame.repaint();
        });
        inputPanel.add(jButton);

        postPonementPanel = new JPanel(new FlowLayout());
        postPonementPanel.add(new TextField("Postponement", false, 8));
        postPonementPanel.add(new TextField("Start:", false));
        postPonementPanel.add(postStartMonth = new TextField("", true));
        postPonementPanel.add(new TextField("Period:", false));
        postPonementPanel.add(postPeriod = new TextField("", true));
        postPonementPanel.add(new TextField("Percent:", false));
        postPonementPanel.add(postPercent = new TextField("", true));

        jFrame = new JFrame("loan graphs");
        jFrame.setLayout(new BorderLayout());
        jFrame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        jFrame.getContentPane().add(postPonementPanel, BorderLayout.AFTER_LAST_LINE);
        jFrame.getContentPane().add(graphPanel, BorderLayout.EAST);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationByPlatform(true);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
