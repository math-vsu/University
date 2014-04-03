package ru.vsu.math.java.ui;

import ru.vsu.math.java.entity.Tutor;
import javax.swing.*;
import java.util.List;

/**
 * Created by Дмитрий on 03.04.14.
 */
class TutorsComboBoxModel extends AbstractListModel implements MutableComboBoxModel {

    private List<Tutor> tutors;
    private Object selectedItem;

    public TutorsComboBoxModel(List<Tutor> tutors) {
        this.tutors = tutors;
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
        return tutors.size();
    }

    @Override
    public Object getElementAt(int index) {
        return tutors.get(index);
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
