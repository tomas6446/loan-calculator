package org.calculator.loan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomas Kozakas
 */
@Getter
@Setter
@NoArgsConstructor
public final class Table {
    private List<Row> rows = new ArrayList<>();

    public void addRow(double initialBalance, double payment, double interestRate, double debtPart, double balanceLeft) {
        rows.add(new Row(initialBalance, payment, interestRate, debtPart, balanceLeft));
    }

    public Row getRow(int index) {
        return rows.get(index);
    }

    public List<Double> getColumn(String name) {
        List<Double> rowsTemp = new ArrayList<>();
        for (Row row : rows)
            switch (name) {
                case "initial" -> rowsTemp.add(row.initialBalance());
                case "payment" -> rowsTemp.add(row.payment());
                case "interest" -> rowsTemp.add(row.interestRate());
                case "debt part" -> rowsTemp.add(row.debtPart());
                case "balance left" -> rowsTemp.add(row.balanceLeft());
                default -> throw new IllegalStateException("Unexpected value: " + name);
            }
        return rowsTemp;
    }
}
