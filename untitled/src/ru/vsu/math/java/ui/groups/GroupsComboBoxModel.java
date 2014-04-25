package ru.vsu.math.java.ui.groups;

import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.util.List;

/**
 * Created by Дмитрий on 11.04.14.
 */
public class GroupsComboBoxModel extends AbstractListModel implements MutableComboBoxModel {

    private List<Group> groups;
    private Object selectedItem;

    public GroupsComboBoxModel(List<Group> groups) {
        this.groups = groups;
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
        return groups.size();
    }

    @Override
    public Object getElementAt(int index) {
        return groups.get(index);
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
