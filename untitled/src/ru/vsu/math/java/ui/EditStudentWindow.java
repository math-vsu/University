package ru.vsu.math.java.ui;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;

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

    public EditStudentWindow(Application app){
        super("Редактирование студента");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Student> students = app.getStudents();
        StudentsComboBoxModel model = new StudentsComboBoxModel(students);
        editStudentComboBox = new JComboBox(model);
        studentNewFullNameField = new JTextField(20);
        updateStudent = new JButton("Обновить данные");
        updateStudent.addActionListener(this);
        editStudentComboBox.addActionListener(this);
        JPanel editStudentPanel = new JPanel(new GridLayout(0,1));
        editStudentPanel.add(editStudentComboBox);
        editStudentPanel.add(studentNewFullNameField);
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
            int selectedIndex = editStudentComboBox.getSelectedIndex();
            student = (Student)app.getStudents().get(selectedIndex);
            app.updateStudent(student, studentNewFullNameField.getText());
            this.setVisible(false);
        }
    }
}
