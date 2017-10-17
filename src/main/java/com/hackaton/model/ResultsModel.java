package com.hackaton.model;

import com.hackaton.interfaces.ResultInterface;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class ResultsModel extends AbstractTableModel {

    private List<ResultInterface> data;
    private final Object[] COLUMNS = {"Nazwa", "Ilość"};

    public ResultsModel(List<ResultInterface> data) {
        this.data = data;
    }

    /**
     * Returns the number of rows in the model. A
     * <code>JTable</code> uses this method to determine how many rows it
     * should display.  This method should be quick, as it
     * is called frequently during rendering.
     *
     * @return the number of rows in the model
     * @see #getColumnCount
     */
    @Override
    public int getRowCount() {
        if(data == null) return 0;
        return data.size();
    }

    /**
     * Returns the number of columns in the model. A
     * <code>JTable</code> uses this method to determine how many columns it
     * should create and display by default.
     *
     * @return the number of columns in the model
     * @see #getRowCount
     */
    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    /**
     * Returns a default name for the column using spreadsheet conventions:
     * A, B, C, ... Z, AA, AB, etc.  If <code>column</code> cannot be found,
     * returns an empty string.
     *
     * @param column the column being queried
     * @return a string containing the default name of <code>column</code>
     */
    @Override
    public String getColumnName(int column) {
        return COLUMNS[column].toString();
    }

    /**
     * Returns false.  This is the default implementation for all cells.
     *
     * @param rowIndex    the row being queried
     * @param columnIndex the column being queried
     * @return false
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     *
     * @param row    the row whose value is to be queried
     * @param column the column whose value is to be queried
     * @return the value Object at the specified cell
     */
    @Override
    public Object getValueAt(int row, int column) {

        if (data == null) return null;
        ResultInterface r = data.get(row);
        switch (column) {
            case 0:
                return r.getName();
            case 1:
                return r.getNumber();
            default:
                return r;
        }
    }
}
