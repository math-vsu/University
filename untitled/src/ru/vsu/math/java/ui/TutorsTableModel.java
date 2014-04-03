package ru.vsu.math.java.ui;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;
import ru.vsu.math.java.entity.Tutor;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Дмитрий on 03.04.14.
 */
public class TutorsTableModel extends AbstractTableModel implements TableModelListener {

    @Override
    public int getRowCount() {
        return Application.getInstance().getTutors().size();
    }
    @Override
    public int getColumnCount() {
        return 2;
    }
    @Override
    public String getValueAt(int row, int column) {
        Tutor tutor = (Tutor) Application.getInstance().getTutors().get(row);
        switch (column) {
            case 0:
                return tutor.getFullName();
            case 1:
                return "TODO";
            case 2:
                return "";
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "ФИО";
                break;
            case 1:
                result = "ID";
                break;
            default:
                return "";
        }
        return result;
    }

    @Override
    public void tableChanged(TableModelEvent tableModelEvent) {
        System.out.println("Data changed!!");
    }
}