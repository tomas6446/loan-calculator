package org.calculator;

import org.calculator.filter.Filter;
import org.calculator.loan.Annuity;
import org.calculator.loan.Linear;
import org.calculator.loan.Postponement;
import org.calculator.window.Window;

/**
 * @author Tomas Kozakas
 */
public class Main {
    public static void main(String[] args) {
        new Filter(new Annuity(10000, 3, 10, 0, new Postponement(3, 4, 1))).getMonthStat();
        new Filter(new Linear(10000, 3, 10, 0, new Postponement(3, 4, 1))).getMonthStat();

        new Window();
    }
}
