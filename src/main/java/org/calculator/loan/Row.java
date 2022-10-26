package org.calculator.loan;

/**
 * @author Tomas Kozakas
 */

public record Row(double initialBalance, double payment, double interestRate, double debtPart, double balanceLeft) { }
