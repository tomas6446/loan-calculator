package org.calculator;

import org.calculator.loan.Postponement;
import org.calculator.window.Window;

/**
 * @author Tomas Kozakas
 */
public class Main {
    public static void main(String[] args) {
        new Window(10000, 3, 10, 0, new Postponement(3, 4, 1));
    }
}
