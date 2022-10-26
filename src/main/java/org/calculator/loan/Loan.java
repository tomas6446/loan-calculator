package org.calculator.loan;

import lombok.Getter;
import lombok.Setter;

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

    public Loan(double balance, double percent, int year, int month, Postponement postponement) {
        this.initialBalance = balance;
        this.balanceLeft = balance;
        this.debtBalance = balance;

        this.period = year * 12 + month;
        this.interestRate = (percent / 100.0) / 12;

        this.table = new Table();
        for (int i = 1; i <= period; i++) {
            if (postponement.getStart() <= i && postponement.getEnd() >= i) {
                table.addRow(getDebtBalance(), 0, postponement.getPostponementInterestRate(), findDebtPart(), findBalanceLeft());
            } else {
                table.addRow(getDebtBalance(), findMonthPayment(), findMonthInterest(), findDebtPart(), findBalanceLeft());
            }
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
