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

    private JTextField groupIdNewField;
    private JTextField tutorIdNewField;
    private JTextField weekdayNewField;
    private JTextField numberNewField;
    private JTextField classroomNewField;

    private JComboBox editDoubleClassComboBox;

    private JLabel groupIdLabel;
    private JLabel tutorIdLabel;
    private JLabel weekdayLabel;
    private JLabel numberLabel;
    private JLabel classroomLabel;

    public EditDoubleClassWindow(Application app){
        super("Редактирование пары");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<DoubleClass> doubleClasses = app.getDoubleClasses();
        DoubleClassesComboBoxModel model = new DoubleClassesComboBoxModel(doubleClasses);
        editDoubleClassComboBox = new JComboBox(model);
        groupIdNewField = new JTextField(20);
        tutorIdNewField = new JTextField(20);
        weekdayNewField = new JTextField(20);
        numberNewField = new JTextField(20);
        classroomNewField = new JTextField(20);
        groupIdLabel = new JLabel("Группа");
        tutorIdLabel = new JLabel("Преподаватель");
        weekdayLabel = new JLabel("День недели");
        numberLabel = new JLabel("Номер пары");
        classroomLabel = new JLabel("Аудитория");
        updateDoubleClass = new JButton("Обновить данные");
        updateDoubleClass.addActionListener(this);
        editDoubleClassComboBox.addActionListener(this);
        JPanel editStudentPanel = new JPanel(new GridLayout(0,1));
        editStudentPanel.add(editDoubleClassComboBox);
        editStudentPanel.add(groupIdLabel);
        editStudentPanel.add(groupIdNewField);
        editStudentPanel.add(tutorIdLabel);
        editStudentPanel.add(tutorIdNewField);
        editStudentPanel.add(weekdayLabel);
        editStudentPanel.add(weekdayNewField);
        editStudentPanel.add(numberLabel);
        editStudentPanel.add(numberNewField);
        editStudentPanel.add(classroomLabel);
        editStudentPanel.add(classroomNewField);
        editStudentPanel.add(updateDoubleClass);
        add(editStudentPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        DoubleClass doubleClass;
        if(src == editDoubleClassComboBox){
           doubleClass = (DoubleClass) app.getDoubleClasses().get(editDoubleClassComboBox.getSelectedIndex());
           groupIdNewField.setText((doubleClass.getGroupId().toString()));
           tutorIdNewField.setText((doubleClass.getTutorId().toString()));
           weekdayNewField.setText((doubleClass.getWeekday().toString()));
           numberNewField.setText((doubleClass.getWeekday().toString()));
           classroomNewField.setText((doubleClass.getClassroom()));
        }

        if(src ==  updateDoubleClass){
            int selectedIndex = editDoubleClassComboBox.getSelectedIndex();
            doubleClass = (DoubleClass)app.getDoubleClasses().get(selectedIndex);
            app.updateDoubleClass(doubleClass, doubleClass.getGroupId(),doubleClass.getTutorId(),doubleClass.getWeekday(),doubleClass.getNumber(),doubleClass.getClassroom());
            this.setVisible(false);
        }
    }
}
