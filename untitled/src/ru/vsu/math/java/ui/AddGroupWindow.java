package ru.vsu.math.java.ui;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class AddGroupWindow extends JFrame implements ActionListener {
    private JTextField course;
    private JTextField group;
    private JTextField  subgroup;
    private JButton addGroupButton;
    private JLabel courseLabel;
    private JLabel groupLabel;
    private JLabel subgroupLabel;
    private Application app;
    public AddGroupWindow(Application app){
        super("Добавление преподавателя");
        setBounds(100, 100, 700, 700);
        this.app = app;
        course = new JTextField(20);
        group = new JTextField(20);
        subgroup = new JTextField(20);
        addGroupButton = new JButton("Добавить группу");
        addGroupButton.addActionListener(this);
        courseLabel = new JLabel("Курс");
        groupLabel = new JLabel("Группа");
        subgroupLabel = new JLabel("Подгруппа");
        JPanel addGroupPanel = new JPanel(new GridLayout(0,1));
        addGroupPanel.add(courseLabel);
        addGroupPanel.add(course);
        addGroupPanel.add(groupLabel);
        addGroupPanel.add(group);
        addGroupPanel.add(subgroupLabel);
        addGroupPanel.add(subgroup);
        addGroupPanel.add(addGroupButton);
        add(addGroupPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Tutor tutor;
        if (src == addGroupButton){
            app.createGroup(course.getText(), group.getText(), subgroup.getText());
            this.setVisible(false);
        }

    }
}