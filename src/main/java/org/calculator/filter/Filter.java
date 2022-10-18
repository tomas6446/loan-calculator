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
    public void getMonthStat() {
        System.out.format("%12s%20s%20s%20s%20s%20s%n", "initial", "month", "payment", "principal", "interest", "ending balance");
        for (int i = 1; i <= loan.getPeriod(); i++) {
            double balance = loan.getBalance();
            double payment = loan.getPayment();
            double principle = loan.getPrinciple();
            double interest = loan.getInterestRate();
            double endBalance =  loan.getEndBalance();

            System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n", i, balance, payment, principle, interest, endBalance);
        }
        System.out.println("Total payment with interest: " + (loan.getInitialBalance() + loan.getTotalInterest()) + "\n");
    }

    @Override
    public void getMonth(int index) {
        for (int i = 1; i <= loan.getPeriod(); i++) {
            double balance = loan.getBalance();
            double payment = loan.getPayment();
            double principle = loan.getPrinciple();
            double interest = loan.getInterestRate();
            double endBalance =  loan.getEndBalance();

            if(i == index) {
                System.out.format("%12d%20.2f%20.2f%20.2f%20.2f%20.2f%n", i, balance, payment, principle, interest, endBalance);
            }
        }
    }
}
