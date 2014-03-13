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
public class DeleteStudentWindow extends JFrame {
    private JButton deleteStudent;
    public DeleteStudentWindow(Application app){
        super("Удаление студента");
        setBounds(100, 100, 700, 700);
        List<Student>students = app.getStudents();
        String[] items = new String[students.size()];
        for(int i=0; i<students.size(); i++) {
            items[i]=students.get(i).getFullName();
        }
        JComboBox combo1 = new JComboBox(items);
        deleteStudent = new JButton("Удалить студента");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(deleteStudent);
        panel.add(combo1);
        add(panel, BorderLayout.NORTH);

    }
}
