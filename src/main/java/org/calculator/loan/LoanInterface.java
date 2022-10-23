package org.calculator.loan;

/**
 * @author Tomas Kozakas
 */
public interface LoanInterface {
    double findMonthPayment();
    double findMonthInterest();
    double findDebtPart();
    double findBalanceLeft();
}
