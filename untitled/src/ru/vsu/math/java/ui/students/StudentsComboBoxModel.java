package ru.vsu.math.java.ui.students;

import ru.vsu.math.java.entity.Student;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: k2_32
 * Date: 21.03.14
 * Time: 9:39
 * To change this template use File | Settings | File Templates.
 */
class StudentsComboBoxModel extends AbstractListModel implements MutableComboBoxModel {

    private List<Student> students;
    private Object selectedItem;

    public StudentsComboBoxModel(List<Student> students) {
        this.students = students;
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
        return students.size();
    }

    @Override
    public Object getElementAt(int index) {
        return students.get(index);
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
