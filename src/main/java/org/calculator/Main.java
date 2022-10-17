package org.calculator;

import org.calculator.filter.Filter;
import org.calculator.loan.Linear;

/**
 * @author Tomas Kozakas
 */
public class Main {
    public static void main(String[] args) {
        new Filter(new Linear(1000, 4, 1, 0)).printMonthStat();
    }
}
