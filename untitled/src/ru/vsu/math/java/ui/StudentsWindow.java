package ru.vsu.math.java.ui;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.*;
import java.util.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class StudentsWindow extends JFrame {
    //Массив содержащий заголоки таблицы
    String[] headers = {"ФИО","Курс","Группа" };

    //Объект таблицы
    JTable studentsTab;
    Application app;
    StudentsTableModel model;

    public StudentsWindow(Application app) {
        super("Список студентов");
        this.app = app;
        this.model = new StudentsTableModel();

        this.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        this.setSize(1000, 170);
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        studentsTab = new JTable(model);
        //studentsTab = new JTable(new UTableModel());
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(studentsTab);
        //Устаналиваем размеры прокручиваемой области
        studentsTab.setPreferredScrollableViewportSize(new Dimension(950, 170));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        this.getContentPane().add(jscrlp);
    }

}