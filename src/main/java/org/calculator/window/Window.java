package org.calculator.window;

import org.calculator.loan.Annuity;
import org.calculator.loan.Linear;
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
    private static org.calculator.window.companent.TextField balanceTextField;
    private static org.calculator.window.companent.TextField percentTextField;
    private static org.calculator.window.companent.TextField yearTextField;
    private static org.calculator.window.companent.TextField monthTextField;
    private static JButton jButton;
    private static ComboBox loanBox;
    private static ComboBox columnBox;
    private static JPanel inputPanel;
    private static Graph graphPanel;

    public Window() {
        graphPanel = new Graph(new Annuity(200, 1, 1, 0).getTable().getColumn("initial"));
        inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new org.calculator.window.companent.TextField("Balance:", false));
        inputPanel.add(balanceTextField = new org.calculator.window.companent.TextField("200", true));
        inputPanel.add(new org.calculator.window.companent.TextField("Percent:", false));
        inputPanel.add(percentTextField = new org.calculator.window.companent.TextField("1", true));
        inputPanel.add(new org.calculator.window.companent.TextField("Year:", false));
        inputPanel.add(yearTextField = new org.calculator.window.companent.TextField("1", true));
        inputPanel.add(new org.calculator.window.companent.TextField("Month:", false));
        inputPanel.add(monthTextField = new TextField("0", true));
        inputPanel.add(loanBox = new ComboBox(new String[]{"Annuity", "Linear"}, "Annuity"));
        inputPanel.add(columnBox = new ComboBox(new String[]{"initial", "payment", "debt part", "balance left"}, "initial"));

        jButton = new JButton("OK");
        jButton.addActionListener(e -> {
            double balance = Double.parseDouble(!balanceTextField.getText().isEmpty() ? balanceTextField.getText() : "0");
            double percent = Double.parseDouble(!percentTextField.getText().isEmpty() ? percentTextField.getText() : "0");
            int year = Integer.parseInt(!yearTextField.getText().isEmpty() ? yearTextField.getText() : "0");
            int month = Integer.parseInt(!monthTextField.getText().isEmpty() ? monthTextField.getText() : "0");

            jFrame.remove(graphPanel);
            switch (loanBox.getChosenItem()) {
                case "Annuity" ->
                        graphPanel = new Graph(new Annuity(balance, percent, year, month).getTable().getColumn(columnBox.getChosenItem()));
                case "Linear" ->
                        graphPanel = new Graph(new Linear(balance, percent, year, month).getTable().getColumn(columnBox.getChosenItem()));
                default -> throw new IllegalStateException("Unexpected value: " + loanBox.getChosenItem());
            }
            jFrame.add(graphPanel);
            jFrame.validate();
            jFrame.repaint();
        });
        inputPanel.add(jButton);

        jFrame = new JFrame("loan graphs");
        jFrame.setLayout(new BorderLayout());
        jFrame.getContentPane().add(inputPanel, BorderLayout.NORTH);
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
