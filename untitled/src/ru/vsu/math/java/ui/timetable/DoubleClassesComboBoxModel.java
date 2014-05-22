package ru.vsu.math.java.ui.timetable;

import ru.vsu.math.java.entity.DoubleClass;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: k2_32
 * Date: 21.03.14
 * Time: 9:39
 * To change this template use File | Settings | File Templates.
 */
class DoubleClassesComboBoxModel extends AbstractListModel implements MutableComboBoxModel {

    private List<DoubleClass> doubleClasses;
    private Object selectedItem;

    public DoubleClassesComboBoxModel(List<DoubleClass> doubleClasses) {
        this.doubleClasses = doubleClasses;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return doubleClasses.size();
    }

    @Override
    public Object getElementAt(int index) {
        return doubleClasses.get(index);
    }

    @Override
    public void addElement(Object item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeElement(Object obj) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void insertElementAt(Object item, int index) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeElementAt(int index) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
