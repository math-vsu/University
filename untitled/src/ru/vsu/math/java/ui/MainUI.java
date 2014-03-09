package ru.vsu.math.java.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: k2_32
 * Date: 07.03.14
 * Time: 9:19
 * To change this template use File | Settings | File Templates.
 */
//класс отвечает за всю графическую оболочку
public class MainUI extends JFrame {
    private JLabel welcomeLabel;
    private JButton studentsListButton;
    private JButton tutorsListButton;
    private JButton groupsListButton;
    private JButton addStudentButton;
    private JButton deleteStudentButton;

    public MainUI(){
        super("University"); //Заголовок окна
        setBounds(100, 100, 1000, 300); //Если не выставить размер и положение - то окно будет мелкое и незаметное
        //Компоненты объекта
        welcomeLabel = new JLabel("Welcome!");
        studentsListButton = new JButton("Вывести список студентов");
        tutorsListButton = new JButton("Вывести список преподавателей");
        groupsListButton = new JButton("Вывести список групп");
        addStudentButton = new JButton("Добавить студента");
        deleteStudentButton = new JButton("Удалить студента");
        //Подготавливаем временные компоненты
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        //Расставляем компоненты по местам
        add(welcomeLabel, BorderLayout.NORTH); //О размещении компонент поговорим позже
        buttonsPanel.add(studentsListButton);
        buttonsPanel.add(tutorsListButton);
        buttonsPanel.add(groupsListButton);
        buttonsPanel.add(addStudentButton);
        buttonsPanel.add(deleteStudentButton);
        add(buttonsPanel, BorderLayout.NORTH);
        initListeners();
    }
    //Привязка кнопки к окну
    private void initListeners() {
        studentsListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentsWindow studentsWindow = new StudentsWindow();
                //studentsWindow.setVisible(true);
            }
        });
        tutorsListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TutorsWindow tutorsWindow = new TutorsWindow();
                tutorsWindow.setVisible(true);
            }
        });
        groupsListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GroupsWindow groupsWindow = new GroupsWindow();
                groupsWindow.setVisible(true);
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudentWindow addStudentWindow = new AddStudentWindow();
                addStudentWindow.setVisible(true);
            }
        });
        deleteStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteStudentWindow deleteStudentWindow = new DeleteStudentWindow();
                deleteStudentWindow.setVisible(true);
            }
        });
    }
}
