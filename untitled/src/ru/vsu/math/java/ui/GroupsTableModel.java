package ru.vsu.math.java.ui;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.entity.Student;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Дмитрий on 11.04.14.
 */
public class GroupsTableModel extends AbstractTableModel implements TableModelListener {

    @Override
    public int getRowCount() {
        return Application.getInstance().getGroups().size();
    }
    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public String getValueAt(int row, int column) {
        Group group = (Group) Application.getInstance().getGroups().get(row);
        switch (column) {
            case 0:
                return group.getCourseNumber();
            case 1:
                return group.getGroupNumber();
            case 2:
                return group.getSubGroupNumber();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "Курс";
                break;
            case 1:
                result = "Группа";
                break;
            case 2:
                result = "Подгруппа";
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