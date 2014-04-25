package ru.vsu.math.java.ui.groups;

import ru.vsu.math.java.entity.Group;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: k2_32
 * Date: 25.04.14
 * Time: 9:29
 * To change this template use File | Settings | File Templates.
 */
public class GroupMenuItem extends JMenuItem {
    private Group group;
    public GroupMenuItem(String title, Group group) {
        // сохраняем параметры группы во внутрених полях, делаем им публичные геттеры и сеттеры
        super(title);
        this.group = group;
    }

    public  Group getGroup(){
        return this.group;
    }

    public void setGroup(Group group){
        this.group = group;
    }
}
