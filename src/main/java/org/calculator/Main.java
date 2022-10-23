package org.calculator;

import org.calculator.draw.Window;
import org.calculator.loan.Annuity;
import org.calculator.loan.Linear;

/**
 * @author Tomas Kozakas
 */
public class Main {
    public static void main(String[] args) {
        new Window(new Annuity(200000, 12, 2, 0));
        new Window(new Linear(200000, 12, 2, 0));
    }
}
