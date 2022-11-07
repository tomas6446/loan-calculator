package org.calculator.window;

import org.calculator.loan.Annuity;
import org.calculator.loan.Linear;
import org.calculator.loan.Loan;
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
    private static ComboBox loanBox;
    private static ComboBox columnBox;
    private static JScrollPane tablePanel;
    private static Graph graphPanel;
    private static JTable jTable;
    private static Loan loan;

    public Window(double balance, double percent, int year, int month, Postponement postponement) {
        loan = new Annuity(balance, percent, year, month, postponement);
        graphPanel = new Graph(loan.getTable().getColumn("payment"));
        jTable = new JTable(loan.getTable().getRowData(), new String[]{"initial", "payment", "interest", "debt part", "balance left"});
        jTable.setFillsViewportHeight(true);

        tablePanel = new JScrollPane(jTable);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new TextField("Balance:", false));
        inputPanel.add(balanceTextField = new TextField(String.valueOf(balance), true));
        inputPanel.add(new TextField("Percent:", false));
        inputPanel.add(percentTextField = new TextField(String.valueOf(percent), true));
        inputPanel.add(new TextField("Year:", false));
        inputPanel.add(yearTextField = new TextField(String.valueOf(year), true));
        inputPanel.add(new TextField("Month:", false));
        inputPanel.add(monthTextField = new TextField(String.valueOf(month), true));
        inputPanel.add(loanBox = new ComboBox(new String[]{"Annuity", "Linear"}, "Annuity"));
        inputPanel.add(columnBox = new ComboBox(new String[]{"payment", "debt part", "balance left"}, "payment"));
        inputPanel.add(new TextField("", false, 20));
        inputPanel.add(new TextField("Postponement", false, 8));
        inputPanel.add(new TextField("Start:", false));
        inputPanel.add(postStartMonth = new TextField(String.valueOf(postponement.getStart()), true));
        inputPanel.add(new TextField("Period:", false));
        inputPanel.add(postPeriod = new TextField(String.valueOf(postponement.getPeriod()), true));
        inputPanel.add(new TextField("Percent:", false));
        inputPanel.add(postPercent = new TextField(String.valueOf(postponement.getPercent()), true));

        JButton jButton = new JButton("OK");
        jButton.addActionListener(e -> {
            double bal = Double.parseDouble(balanceTextField.toString());
            double per = Double.parseDouble(percentTextField.toString());
            int y = Integer.parseInt(yearTextField.toString());
            int m = Integer.parseInt(monthTextField.toString());

            int start = Integer.parseInt(postStartMonth.toString());
            int period = Integer.parseInt(postPeriod.toString());
            double percentPost = Double.parseDouble(postPercent.toString());
            Postponement post = new Postponement(start, period, percentPost);

            jFrame.remove(graphPanel);
            jFrame.remove(tablePanel);

            switch (loanBox.getChosenItem()) {
                case "Annuity" -> loan = new Annuity(bal, per, y, m, post);
                case "Linear" -> loan = new Linear(bal, per, y, m, post);
                default -> throw new IllegalStateException("Unexpected value: " + loanBox.getChosenItem());
            }
            graphPanel = new Graph(loan.getTable().getColumn(columnBox.getChosenItem()));
            jTable = new JTable(loan.getTable().getRowData(), new String[]{"initial", "payment", "interest", "debt part", "balance left"});
            jTable.setFillsViewportHeight(true);
            tablePanel = new JScrollPane(jTable);

            jFrame.add(tablePanel, BorderLayout.CENTER);
            jFrame.add(graphPanel, BorderLayout.NORTH);
            jFrame.validate();
            jFrame.repaint();
        });
        inputPanel.add(jButton);

        jFrame = new JFrame("loan graphs");
        jFrame.add(graphPanel, BorderLayout.NORTH);
        jFrame.add(tablePanel, BorderLayout.CENTER);
        jFrame.add(inputPanel, BorderLayout.PAGE_END);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationByPlatform(true);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
