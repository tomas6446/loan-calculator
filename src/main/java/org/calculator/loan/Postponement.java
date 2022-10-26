package org.calculator.loan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
@NoArgsConstructor
public class Postponement {
    private int start;
    private int end;
    private double percent;
    private double postponementInterestRate;

    public Postponement(int month, int period, double percent) {
        this.start = month;
        this.end = month + period;
        this.percent = percent;
        this.postponementInterestRate = (percent / 100.0) / 12;
    }
}
