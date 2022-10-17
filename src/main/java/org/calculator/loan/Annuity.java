package org.calculator.loan;

/**
 * @author Tomas Kozakas
 */
public class Annuity extends Loan {
    public Annuity(double amount, double percent, int year, int month) {
        super(amount, percent, year, month);
    }
    @Override
    public double findLoan(int time) {
        return Math.round(getAmount() * ((getPercent() / 100.0) / 12.0)) / (1 - Math.pow(1 + ((getPercent() / 100.0) / 12.0), -(time)));
    }
}
