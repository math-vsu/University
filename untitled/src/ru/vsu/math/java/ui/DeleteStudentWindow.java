package ru.vsu.math.java.ui;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class DeleteStudentWindow extends JFrame implements ActionListener {
    private JButton deleteStudent;
    private JComboBox combo1;
    private Application app;
    public DeleteStudentWindow(Application app){
        super("Удаление студента");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Student>students = app.getStudents();
//        String[] items = new String[students.size()];
//        for(int i=0; i<students.size(); i++) {
//            items[i]=students.get(i).getFullName();
//        }
        StudentsComboBoxModel model = new StudentsComboBoxModel(students);
        combo1 = new JComboBox(model);
        deleteStudent = new JButton("Удалить студента");
        deleteStudent.addActionListener(this);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(deleteStudent);
        panel.add(combo1);
        add(panel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Student student;
        if (src == deleteStudent) {
             int selectedIndex = combo1.getSelectedIndex();
             combo1.removeItemAt(selectedIndex);
             student = (Student)app.getStudents().get(selectedIndex);
             app.deleteStudent(student);
        }

    }
}
