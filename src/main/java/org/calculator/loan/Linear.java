package org.calculator.loan;


/**
 * @author Tomas Kozakas
 */
public class Linear extends Loan {

    public Linear(double balance, double percent, int year, int month) {
        super(balance, percent, year, month);
    }

    public Linear(double balance, double percent, int year, int month, Postponement postponement) {
        super(balance, percent, year, month, postponement);
    }

    @Override
    public double findDebtPart() {
        return getInitialBalance() / getPeriod();
    }

    @Override
    public double findMonthPayment() {
        return findDebtPart() + findMonthInterest();
    }
}
