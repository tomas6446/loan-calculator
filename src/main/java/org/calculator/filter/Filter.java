package org.calculator.filter;

import org.calculator.loan.Loan;
import org.calculator.loan.Table;

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
        for (Table table : loan.getFullTable()) {
            System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n", table.month(), table.initialBalance(), table.payment(), table.interestRate(), table.debtPart(), table.balanceLeft());
        }
    }

    public void getMonthStat(int index) {
        System.out.format("%12s%20s%20s%20s%20s%20s%n", "month", "initial", "payment", "interest", "debt part", "balance left");
        Table table = loan.getFullTable().get(index);
        System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n", table.month(), table.initialBalance(), table.payment(), table.interestRate(), table.debtPart(), table.balanceLeft());
    }
}
