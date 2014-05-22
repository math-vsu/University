package ru.vsu.math.java.ui.timetable;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.DoubleClass;
import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.entity.Student;
import ru.vsu.math.java.ui.groups.GroupsComboBoxModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: k2_32
 * Date: 28.03.14
 * Time: 8:47
 * To change this template use File | Settings | File Templates.
 */
public class EditDoubleClassWindow extends JFrame implements ActionListener {
    private Application app;
    private JButton updateDoubleClass;
    private JTextField doubleClassNewField;
    private JComboBox editDoubleClassComboBox;
    private JComboBox studentGroupComboBox;

    public EditDoubleClassWindow(Application app){
        super("Редактирование пары");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<DoubleClass> doubleClasses = app.getDoubleClasses();
        List<Group> groups = app.getGroups();
        DoubleClassesComboBoxModel doubleClassesModel = new DoubleClassesComboBoxModel(doubleClasses);
        editDoubleClassComboBox = new JComboBox(doubleClassesModel);
        GroupsComboBoxModel groupsModel = new GroupsComboBoxModel(groups);
        studentGroupComboBox = new JComboBox(groupsModel);
        doubleClassNewField = new JTextField(20);
        updateDoubleClass = new JButton("Обновить данные");
        updateDoubleClass.addActionListener(this);
        editDoubleClassComboBox.addActionListener(this);
        JPanel editStudentPanel = new JPanel(new GridLayout(0,1));
        editStudentPanel.add(editDoubleClassComboBox);
        editStudentPanel.add(doubleClassNewField);
        editStudentPanel.add(studentGroupComboBox);
        editStudentPanel.add(updateDoubleClass);
        add(editStudentPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        DoubleClass doubleClass;
        if(src == editDoubleClassComboBox){
            doubleClassNewField.setText(editDoubleClassComboBox.getSelectedItem().toString());
        }

        if(src ==  updateDoubleClass){
            int selectedIndex = editDoubleClassComboBox.getSelectedIndex();
            doubleClass = (DoubleClass)app.getDoubleClasses().get(selectedIndex);
            app.updateDoubleClass(doubleClass, null,null,null,null,null);
            this.setVisible(false);
        }
    }
}
