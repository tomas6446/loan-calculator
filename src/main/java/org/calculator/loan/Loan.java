package org.calculator.loan;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
public abstract class Loan implements LoanInterface {
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
    }

    public List<Table> getFullTable() {
        List<Table> table = new ArrayList<>();
        for (int i = 1; i <= period; i++) {
            table.add(new Table(i, getDebtBalance(), findMonthPayment(), findMonthInterest(), findDebtPart(), findBalanceLeft()));
        }
        return table;
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
