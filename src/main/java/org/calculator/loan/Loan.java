package org.calculator.loan;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
abstract public class Loan implements LoanInterface {
    private double balance;
    private double endingBalance;
    private double initialBalance;
    private double totalInterest;
    private double percent;
    private int year;
    private int month;

    public Loan(double balance, double percent, int year, int month) {
        this.balance = balance;
        this.percent = percent;
        this.year = year;
        this.month = month;
        this.endingBalance = balance;
        this.initialBalance = balance;
    }

    @Override
    public int getPeriod() {
        return getYear() * 12 + getMonth();
    }

    @Override
    public double getPrinciple() {
        return getPayment() - getInterestRate();
    }

    @Override
    public double getMonthlyRate() {
        return getPercent() / 100 / getPeriod();
    }

    @Override
    public double getEndBalance() {
        double balance = endingBalance - getPrinciple();
        setEndingBalance(Math.max(balance, 0));
        setBalance(endingBalance);
        return endingBalance;
    }
}
