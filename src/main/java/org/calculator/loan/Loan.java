package org.calculator.loan;

import lombok.Getter;
import lombok.Setter;
import org.calculator.loan.table.Table;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
public abstract class Loan implements LoanInterface {
    private Table table;
    private double debtBalance;
    private double initialBalance;
    private double balanceLeft;

    private double percent;
    private double interestRate;
    private int period;

    public Loan() {
        this(0.0, 0.0, 0, 0);
    }

    public Loan(double balance, double percent, int year, int month) {
        this.initialBalance = balance;
        this.balanceLeft = balance;
        this.debtBalance = balance;

        this.period = year * 12 + month;
        this.interestRate = (percent / 100.0) / 12;

        this.table = new Table();
        for (int i = 1; i <= period; i++) {
            table.addRow(getDebtBalance(), findMonthPayment(), findMonthInterest(), findDebtPart(), findBalanceLeft());
        }
    }

    @Override
    public double findMonthInterest() {
        return getBalanceLeft() * getInterestRate();
    }

    @Override
    public double findBalanceLeft() {
        balanceLeft = Math.abs(balanceLeft - findDebtPart());
        debtBalance = balanceLeft;
        return balanceLeft;
    }
}
