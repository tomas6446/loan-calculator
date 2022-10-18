package org.calculator.loan;


/**
 * @author Tomas Kozakas
 */
public class Linear extends Loan {
    public Linear(double balance, double percent, int year, int month) {
        super(balance, percent, year, month);
    }
    @Override
    public double getInterestRate() {
        return 0;
    }

    @Override
    public double getPayment() {
        return (getInitialBalance() * getMonthlyRate()) / (1 - Math.pow(1 + getMonthlyRate(), -(getPeriod())));
    }
}
