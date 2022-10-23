package org.calculator.loan;

/**
 * @author Tomas Kozakas
 */
public class Annuity extends Loan {
    public Annuity(double balance, double percent, int year, int month) {
        super(balance, percent, year, month);
    }
    @Override
    public double findDebtPart() {
        return findMonthPayment() - findMonthInterest();
    }

    @Override
    public double findMonthPayment() {
        return getInitialBalance() * (getInterestRate() + (getInterestRate() / (Math.pow(1 + getInterestRate(), getPeriod()) - 1)));
    }
}
