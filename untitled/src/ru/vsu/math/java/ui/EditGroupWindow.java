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
public class EditGroupWindow extends JFrame implements ActionListener {
    private Application app;
    private JButton updateGroup;
    private JTextField courseNewField;
    private JTextField groupNewField;
    private JTextField subgroupNewField;
    private JComboBox editGroupComboBox;
    private JLabel courseLabel;
    private JLabel groupLabel;
    private JLabel subgroupLabel;

    public EditGroupWindow(Application app){
        super("Редактирование группы");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Group> groups = app.getGroups();
        GroupsComboBoxModel model = new GroupsComboBoxModel(groups);
        editGroupComboBox = new JComboBox(model);
        courseNewField = new JTextField(20);
        groupNewField = new JTextField(20);
        subgroupNewField = new JTextField(20);
        courseLabel = new JLabel("Курс");
        groupLabel = new JLabel("Группа");
        subgroupLabel = new JLabel("Подгруппа");
        updateGroup = new JButton("Обновить данные");
        updateGroup.addActionListener(this);
        editGroupComboBox.addActionListener(this);
        JPanel editGroupPanel = new JPanel(new GridLayout(0,1));
        editGroupPanel.add(editGroupComboBox);
        editGroupPanel.add(courseLabel);
        editGroupPanel.add(courseNewField);
        editGroupPanel.add(groupLabel);
        editGroupPanel.add(groupNewField);
        editGroupPanel.add(subgroupLabel);
        editGroupPanel.add(subgroupNewField);
        editGroupPanel.add(updateGroup);
        add(editGroupPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Group group;
        if(src ==  editGroupComboBox){
            groupNewField.setText(editGroupComboBox.getSelectedItem().toString());
        }

        if(src == updateGroup){
            int selectedIndex = editGroupComboBox.getSelectedIndex();
            group = (Group)app.getGroups().get(selectedIndex);
            app.updateGroup(group,courseNewField.getText(), groupNewField.getText(), subgroupNewField.getText());
            this.setVisible(false);
        }
    }
}
