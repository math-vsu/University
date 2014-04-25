package ru.vsu.math.java.ui.students;

import ru.vsu.math.java.Application;
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
public class EditStudentWindow extends JFrame implements ActionListener {
    private Application app;
    private JButton updateStudent;
    private JTextField studentNewFullNameField;
    private JComboBox editStudentComboBox;
    private JComboBox studentGroupComboBox;

    public EditStudentWindow(Application app){
        super("Редактирование студента");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Student> students = app.getStudents();
        List<Group> groups = app.getGroups();
        StudentsComboBoxModel studentsModel = new StudentsComboBoxModel(students);
        editStudentComboBox = new JComboBox(studentsModel);
        GroupsComboBoxModel groupsModel = new GroupsComboBoxModel(groups);
        studentGroupComboBox = new JComboBox(groupsModel);
        studentNewFullNameField = new JTextField(20);
        updateStudent = new JButton("Обновить данные");
        updateStudent.addActionListener(this);
        editStudentComboBox.addActionListener(this);
        JPanel editStudentPanel = new JPanel(new GridLayout(0,1));
        editStudentPanel.add(editStudentComboBox);
        editStudentPanel.add(studentNewFullNameField);
        editStudentPanel.add(studentGroupComboBox);
        editStudentPanel.add(updateStudent);
        add(editStudentPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Student student;
        if(src == editStudentComboBox){
            studentNewFullNameField.setText(editStudentComboBox.getSelectedItem().toString());
        }

        if(src == updateStudent){
            Group group=(Group)app.getGroups().get(studentGroupComboBox.getSelectedIndex());
            int selectedIndex = editStudentComboBox.getSelectedIndex();
            student = (Student)app.getStudents().get(selectedIndex);
            app.updateStudent(student, studentNewFullNameField.getText(),group.getGroupId());
            this.setVisible(false);
        }
    }
}
