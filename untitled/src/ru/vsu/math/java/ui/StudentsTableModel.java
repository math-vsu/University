package ru.vsu.math.java.ui;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class StudentsTableModel extends AbstractTableModel implements TableModelListener {

    @Override
    public int getRowCount() {
        return Application.getInstance().getStudents().size();
    }
    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public String getValueAt(int row, int column) {
        Student student = (Student) Application.getInstance().getStudents().get(row);
        switch (column) {
            case 0:
                return student.getFullName();
            case 1:
                return student.getGroup().name();
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
                result = "Группа";
                break;
            case 2:
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
