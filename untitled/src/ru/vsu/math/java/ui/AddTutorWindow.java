package ru.vsu.math.java.ui;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Student;
import ru.vsu.math.java.entity.Tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

/**
 * Created by Дмитрий on 03.04.14.
 */
public class AddTutorWindow extends JFrame implements ActionListener {
    private JTextField tutorFullNameField;
    private JButton addTutorButton;
    private Application app;
    public AddTutorWindow(Application app){
        super("Добавление преподавателя");
        setBounds(100, 100, 700, 700);
        this.app = app;
        tutorFullNameField = new JTextField(20);
        addTutorButton = new JButton("Добавить преподавателя");
        addTutorButton.addActionListener(this);
        JPanel addTutorPanel = new JPanel(new GridLayout(0,1));
        addTutorPanel.add(tutorFullNameField);
        addTutorPanel.add(addTutorButton);
        add(addTutorPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Tutor tutor;
        if (src == addTutorButton){
            String name = tutorFullNameField.getText();
            app.createTutor(name,null);
            this.setVisible(false);
        }

    }
}
