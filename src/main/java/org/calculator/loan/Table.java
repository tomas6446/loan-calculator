package org.calculator.loan;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tomas Kozakas
 */

public record Table(int month, double initialBalance, double payment, double interestRate, double debtPart,
                    double balanceLeft) {
}
