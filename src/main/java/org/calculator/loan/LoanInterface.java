package org.calculator.loan;

/**
 * @author Tomas Kozakas
 */
public interface LoanInterface {
    int getPeriod();

    double getPayment();

    double getBalance();

    double getMonthlyRate();

    double getInterestRate();

    double getPrinciple();

    double getEndBalance();
}
