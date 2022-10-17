package org.calculator.filter;

import org.calculator.loan.Loan;

/**
 * @author Tomas Kozakas
 */
public class Filter implements FilterInterface {
    private final Loan loan;

    public Filter(Loan loan) {
        this.loan = loan;
    }

    @Override
    public void printMonthStat() {
        int months = loan.getYear() * 12 + loan.getMonth();
        System.out.println("\n");
        for (int i = 0; i < months; i++) {
            System.out.format("%10d%s", i + 1, " Months");
        }
        System.out.println("\n");
        for (int i = 0; i < months; i++) {
            System.out.format("%15.1f", loan.findLoan(i + 1));
        }
        System.out.println("\n");
    }
}
