package org.calculator;

import org.calculator.window.Window;
import org.calculator.filter.Filter;
import org.calculator.loan.Annuity;
import org.calculator.loan.Linear;

/**
 * @author Tomas Kozakas
 */
public class Main {
    public static void main(String[] args) {
        new Filter(new Annuity(200, 1, 1, 0)).getFromMonthStat(4);
        new Filter(new Linear(200, 1, 1, 0)).getFromMonthStat(4);

        new Window();
    }
}
