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
        System.out.println("\n");
        System.out.format("%12s%20s%20s%20s%20s%20s%n", "initial", "month", "payment", "principal", "interest", "ending balance");
        for (int i = 1; i <= loan.getPeriod(); i++) {
            System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n", i, loan.getBalance(), loan.getPayment(), loan.getPrinciple(), loan.getInterestRate(), loan.getEndBalance());
        }
    }
}
