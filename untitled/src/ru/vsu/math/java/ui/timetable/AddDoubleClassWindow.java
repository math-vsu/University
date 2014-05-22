package ru.vsu.math.java.ui.timetable;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.DoubleClass;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class AddDoubleClassWindow extends JFrame implements ActionListener {
    private JTextField doubleClassField;
    private JButton addDoubleClassButton;
    private Application app;
    public AddDoubleClassWindow(Application app){
        super("Добавление пары");
        setBounds(100, 100, 700, 700);
        this.app = app;
        doubleClassField = new JTextField(20);
        addDoubleClassButton = new JButton("Добавить пару");
        addDoubleClassButton.addActionListener(this);
        JPanel addStudentPanel = new JPanel(new GridLayout(0,1));
        addStudentPanel.add(doubleClassField);
        addStudentPanel.add(addDoubleClassButton);
        add(addStudentPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        DoubleClass doubleClass;
        if (src == addDoubleClassButton){
            app.createDoubleClass(null,null,null,null,null);
            this.setVisible(false);
        }

    }
}
