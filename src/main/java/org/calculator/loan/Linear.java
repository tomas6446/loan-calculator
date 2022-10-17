package org.calculator.loan;

/**
 * @author Tomas Kozakas
 */
public class Linear extends Loan {
    public Linear(double amount, double percent, int year, int month) {
        super(amount, percent, year, month);
    }

    @Override
    public double findLoan(int months) {
        return Math.round(getAmount() * (getPercent() / 100.0) * (months));
    }
}
