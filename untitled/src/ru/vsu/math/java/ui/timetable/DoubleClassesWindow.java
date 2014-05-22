package ru.vsu.math.java.ui.timetable;

import ru.vsu.math.java.Application;

import javax.swing.*;
import java.awt.*;

public class DoubleClassesWindow extends JFrame {
    //Массив содержащий заголоки таблицы
    String[] headers = {"Группа","Преподаватель","День недели", "Номер пары", "Аудитория"};

    //Объект таблицы
    JTable doubleClassesTab;
    Application app;
    DoubleClassesTableModel model;

    public DoubleClassesWindow(Application app) {
        super("Список студентов");
        this.app = app;
        this.model = new DoubleClassesTableModel();

        this.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        this.setSize(1000, 170);
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        doubleClassesTab = new JTable(model);
        //studentsTab = new JTable(new UTableModel());
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(doubleClassesTab);
        //Устаналиваем размеры прокручиваемой области
        doubleClassesTab.setPreferredScrollableViewportSize(new Dimension(950, 170));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        this.getContentPane().add(jscrlp);
    }

}