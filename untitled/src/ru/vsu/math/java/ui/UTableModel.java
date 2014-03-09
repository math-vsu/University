package ru.vsu.math.java.ui;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class UTableModel extends AbstractTableModel {
    Application app = new Application();
    @Override
    public int getRowCount() {
        return app.getStudents().size();
    }
    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
               // return //app.getStudents().getFullName();
            case 1:
               // return //app.getStudents().getGroup();
            case 2:
               // return //app.getStudents().id();
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
}
