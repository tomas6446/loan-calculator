package org.calculator.filter;

import org.calculator.loan.Loan;
import org.calculator.loan.Row;

/**
 * @author Tomas Kozakas
 */
public class Filter implements FilterInterface {
    private final Loan loan;

    public Filter(Loan loan) {
        this.loan = loan;
    }

    @Override
    public void getMonthStat() {
        System.out.format("%12s%20s%20s%20s%20s%20s%n", "month", "initial", "payment", "interest", "debt part", "balance left");
        for (int i = 0; i < loan.getTable().getRows().size(); i++) {
            Row row = loan.getTable().getRow(i);
            System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n", i + 1, row.initialBalance(), row.payment(), row.interestRate(), row.debtPart(), row.balanceLeft());
        }
        System.out.println("\n");
    }

    public void getMonthStat(int month) {
        System.out.format("%12s%20s%20s%20s%20s%20s%n", "month", "initial", "payment", "interest", "debt part", "balance left");
        Row row = loan.getTable().getRow(month - 1);
        System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n%n", month, row.initialBalance(), row.payment(), row.interestRate(), row.debtPart(), row.balanceLeft());
    }

    public void getFromMonthStat(int month) {
        System.out.format("%12s%20s%20s%20s%20s%20s%n", "month", "initial", "payment", "interest", "debt part", "balance left");
        for (int i = month - 1; i < loan.getTable().getRows().size(); i++) {
            Row row = loan.getTable().getRow(i);
            System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n", i + 1, row.initialBalance(), row.payment(), row.interestRate(), row.debtPart(), row.balanceLeft());
        }
        System.out.println("\n");
    }
}
