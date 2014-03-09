package ru.vsu.math.java.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

public class StudentsWindow extends JFrame {
    //Массив содержащий заголоки таблицы
    String[] headers = {"ФИО","Курс","Группа" };

    //Массив содержащий информацию для таблицы
    String[][] data = {
            {"Соловьев Дмитрий Николаевич", "2", "3.2"},
            {"Савенков Михаил Владиславович", "2", "3.2"},
            {"Новоселов Антон Григорьевич", "2", "3.2"},
            {"Шипилов Алексей Владимирович", "2", "3.2"},
            {"Шилин Семен Иванович", "2", "3.2"},
            {"Микляев Владислав Иванович", "2", "3.2"},
            {"Измайлова Марина Анатольевна", "2", "3.2"},
            {"Щеблыкина Ирина Владимировна", "2", "3.2"},
            {"Кольцова Карелия Бенедиктовна", "2", "3.2"},
            {"Ляхов Владислав Иванович", "2", "3.2"},
    };

    //Объект таблицы
    JTable studentsTab;

    public StudentsWindow() {
        super("Список студентов");
        this.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        this.setSize(1000, 170);
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        studentsTab = new JTable(data, headers);
        //studentsTab = new JTable(new UTableModel());
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(studentsTab);
        //Устаналиваем размеры прокручиваемой области
        studentsTab.setPreferredScrollableViewportSize(new Dimension(950, 170));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        this.getContentPane().add(jscrlp);
    }
}