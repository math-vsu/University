package ru.vsu.math.java.ui.timetable;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.DoubleClass;
import ru.vsu.math.java.entity.Student;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class DoubleClassesTableModel extends AbstractTableModel implements TableModelListener {

    @Override
    public int getRowCount() {
        return Application.getInstance().getDoubleClasses().size();
    }
    @Override
    public int getColumnCount() {
        return 5;
    }
    @Override
    public String getValueAt(int row, int column) {
        DoubleClass doubleClass = (DoubleClass) Application.getInstance().getStudents().get(row);
        switch (column) {
            case 0:
                return doubleClass.getGroupId().toString();
            case 1:
                return doubleClass.getTutorId().toString();
            case 2:
                return doubleClass.getWeekday().toString();
            case 3:
                return doubleClass.getNumber().toString();
            case 4:
                return doubleClass.getClassroom();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "Группа";
                break;
            case 1:
                result = "Преподаватель";
                break;
            case 2:
                result = "День недели";
                break;
            case 3:
                result = "Номер пары";
                break;
            case 4:
                result = "Аудитория";
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
