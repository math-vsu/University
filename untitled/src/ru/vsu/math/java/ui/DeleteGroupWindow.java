package ru.vsu.math.java.ui;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Дмитрий on 11.04.14.
 */
public class DeleteGroupWindow extends JFrame implements ActionListener {
    private JButton deleteGroup;
    private JComboBox deleteGroupComboBox;
    private Application app;
    public DeleteGroupWindow(Application app){
        super("Удаление группы");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Group> groups = app.getGroups();
        GroupsComboBoxModel model = new GroupsComboBoxModel(groups);
        deleteGroupComboBox = new JComboBox(model);
        deleteGroup = new JButton("Удалить группу");
        deleteGroup.addActionListener(this);
        JPanel deleteGroupPanel = new JPanel(new GridLayout(0, 1));
        deleteGroupPanel.add(deleteGroup);
        deleteGroupPanel.add(deleteGroupComboBox);
        add(deleteGroupPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Group group;
        if (src == deleteGroup) {
            int selectedIndex = deleteGroupComboBox.getSelectedIndex();
            deleteGroupComboBox.removeItemAt(selectedIndex);
            group = (Group)app.getGroups().get(selectedIndex);
            app.deleteGroup(group);
            this.setVisible(false);
        }

    }
}

