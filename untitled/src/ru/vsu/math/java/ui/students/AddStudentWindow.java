package ru.vsu.math.java.ui.students;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class AddStudentWindow extends JFrame implements ActionListener {
    private JTextField studentFullNameField;
    private JButton addStudentButton;
    private Application app;
    public AddStudentWindow(Application app){
        super("Добавление студента");
        setBounds(100, 100, 700, 700);
        this.app = app;
        studentFullNameField = new JTextField(20);
        addStudentButton = new JButton("Добавить студента");
        addStudentButton.addActionListener(this);
        JPanel addStudentPanel = new JPanel(new GridLayout(0,1));
        addStudentPanel.add(studentFullNameField);
        addStudentPanel.add(addStudentButton);
        add(addStudentPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Student student;
        if (src == addStudentButton){
            String name = studentFullNameField.getText();
            app.createStudent(name,null,null);
            this.setVisible(false);
        }

    }
}
