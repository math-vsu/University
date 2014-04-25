package ru.vsu.math.java.ui.students;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class DeleteStudentWindow extends JFrame implements ActionListener {
    private JButton deleteStudent;
    private JComboBox deleteStudentComboBox;
    private Application app;
    public DeleteStudentWindow(Application app){
        super("Удаление студента");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Student>students = app.getStudents();
        StudentsComboBoxModel model = new StudentsComboBoxModel(students);
        deleteStudentComboBox = new JComboBox(model);
        deleteStudent = new JButton("Удалить студента");
        deleteStudent.addActionListener(this);
        JPanel deleteStudentPanel = new JPanel(new GridLayout(0, 1));
        deleteStudentPanel.add(deleteStudent);
        deleteStudentPanel.add(deleteStudentComboBox);
        add(deleteStudentPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Student student;
        if (src == deleteStudent) {
             int selectedIndex = deleteStudentComboBox.getSelectedIndex();
             deleteStudentComboBox.removeItemAt(selectedIndex);
             student = (Student)app.getStudents().get(selectedIndex);
             app.deleteStudent(student);
             this.setVisible(false);
        }

    }
}
