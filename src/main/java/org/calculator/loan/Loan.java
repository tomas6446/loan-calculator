package org.calculator.loan;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
abstract public class Loan implements LoanInterface {
    private final double amount;
    private final double percent;
    private final int year;
    private final int month;

    public Loan(double amount, double percent, int year, int month) {
        this.amount = amount;
        this.year = year;
        this.month = month;
        this.percent = percent;
    }
}
