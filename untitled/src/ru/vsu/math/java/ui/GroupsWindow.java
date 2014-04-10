package ru.vsu.math.java.ui;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Group;
/**
 * Created by Дмитрий on 09.03.14.
 */
public class GroupsWindow extends JFrame {
    //Массив содержащий заголоки таблицы
    String[] headers = {"Курс","Группа","Подгруппа"};

    //Объект таблицы
    JTable groupsTab;
    Application app;
    GroupsTableModel model;

    public GroupsWindow(Application app) {
        super("Список групп");
        this.app = app;
        this.model = new GroupsTableModel();

        this.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        this.setSize(1000, 170);
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        groupsTab = new JTable(model);
        //studentsTab = new JTable(new UTableModel());
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(groupsTab);
        //Устаналиваем размеры прокручиваемой области
        groupsTab.setPreferredScrollableViewportSize(new Dimension(950, 170));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        this.getContentPane().add(jscrlp);
    }

}
