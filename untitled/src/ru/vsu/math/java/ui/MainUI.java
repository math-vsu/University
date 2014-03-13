package ru.vsu.math.java.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ru.vsu.math.java.*;


//класс отвечает за всю графическую оболочку
public class MainUI extends JFrame implements ActionListener {
    private Application app;
    private JLabel welcomeLabel;
    private JButton studentsListButton;
    private JButton tutorsListButton;
    private JButton groupsListButton;
    private JButton addStudentButton;
    private JButton deleteStudentButton;
    private StudentsWindow studentsWindow;
    private AddStudentWindow addStudentWindow;
    private DeleteStudentWindow deleteStudentWindow;

    public MainUI(Application app) {
        super("University"); //Заголовок окна

        this.app = app;
        studentsWindow = new StudentsWindow(app);
        deleteStudentWindow = new DeleteStudentWindow(app);
        setBounds(100, 100, 1000, 300); //Если не выставить размер и положение - то окно будет мелкое и незаметное

        //Компоненты объекта
        welcomeLabel = new JLabel("Welcome!");

        studentsListButton = new JButton("Вывести список студентов");
        studentsListButton.addActionListener(this);

        tutorsListButton = new JButton("Вывести список преподавателей");
        groupsListButton = new JButton("Вывести список групп");
        addStudentButton = new JButton("Добавить студента");
        addStudentButton.addActionListener(this);
        deleteStudentButton = new JButton("Удалить студента");
        deleteStudentButton.addActionListener(this);
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
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();

        if (src == studentsListButton) {
            studentsWindow.setVisible(true);
        }

        if (src == addStudentButton) {
            addStudentWindow.setVisible(true);
        }

        if (src == deleteStudentButton) {
            deleteStudentWindow.setVisible(true);
        }



    }
}
