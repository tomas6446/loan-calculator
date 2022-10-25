package org.calculator.draw;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
public class ComboBox extends JComboBox<String> implements ActionListener {
    private String chosenItem;
    private String[] items;

    public ComboBox(String[] items, String chosenItem) {
        Arrays.stream(items).forEach(this::addItem);
        this.addActionListener(this);
        this.chosenItem = chosenItem;
        this.items = items;
    }

    public void actionPerformed(ActionEvent e) {
        var comboBox = (JComboBox) e.getSource();
        chosenItem = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
        comboBox.hidePopup();
    }
}
