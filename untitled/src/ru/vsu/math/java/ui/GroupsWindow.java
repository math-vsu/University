package ru.vsu.math.java.ui;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import ru.vsu.math.java.entity.Group;
/**
 * Created by Дмитрий on 09.03.14.
 */
public class GroupsWindow extends JFrame {
    public GroupsWindow(List list){
        super("Список групп");
        setBounds(100, 100, 700, 700);
        List<Group> groupsList = list;
    }
}
