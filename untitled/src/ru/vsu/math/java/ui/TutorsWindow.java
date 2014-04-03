package ru.vsu.math.java.ui;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.*;
import java.util.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class TutorsWindow extends JFrame {
    //Массив содержащий заголоки таблицы
    String[] headers = {"ФИО"};

    //Объект таблицы
    JTable tutorsTab;
    Application app;
    TutorsTableModel model;

    public TutorsWindow(Application app) {
        super("Список преподавателей");
        this.app = app;
        this.model = new TutorsTableModel();

        this.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        this.setSize(1000, 170);
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        tutorsTab = new JTable(model);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(tutorsTab);
        //Устаналиваем размеры прокручиваемой области
        tutorsTab.setPreferredScrollableViewportSize(new Dimension(950, 170));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        this.getContentPane().add(jscrlp);
    }

}
