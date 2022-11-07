package org.calculator.loan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    public String[][] getRowData() {
        DecimalFormat df = new DecimalFormat("#.##");
        String[][] data = new String[rows.size()][5];
        for (Row row : rows) {
            data[rows.indexOf(row)][0] = df.format(row.initialBalance());
            data[rows.indexOf(row)][1] = df.format(row.payment());
            data[rows.indexOf(row)][2] = df.format(row.interestRate());
            data[rows.indexOf(row)][3] = df.format(row.debtPart());
            data[rows.indexOf(row)][4] = df.format(row.balanceLeft());
        }
        return data;
    }
}
