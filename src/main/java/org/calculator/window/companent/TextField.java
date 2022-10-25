package org.calculator.window.companent;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
public class TextField extends JFormattedTextField implements ActionListener {
    public TextField(String text, boolean editable) {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);

        this.setEditable(editable);
        this.setFont(new JTextField().getFont().deriveFont(15f));
        this.setColumns(4);
        this.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        this.setText(this.getText() + s);
    }
}
