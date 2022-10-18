package org.calculator.loan;

/**
 * @author Tomas Kozakas
 */
public class Annuity extends Loan {
    public Annuity(double balance, double percent, int year, int month) {
        super(balance, percent, year, month);
    }
    @Override
    public double getInterestRate() {
        super.setTotalInterest(super.getTotalInterest() + (getBalance() * (1 + getMonthlyRate()) - getBalance()));
        return getBalance() * (1 + getMonthlyRate()) - getBalance();
    }

    @Override
    public double getPayment() {
        return (getInitialBalance() * getMonthlyRate()) / (1 - Math.pow(1 + getMonthlyRate(), -(getPeriod())));
    }
}
