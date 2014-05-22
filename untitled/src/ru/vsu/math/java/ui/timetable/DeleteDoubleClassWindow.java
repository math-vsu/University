package ru.vsu.math.java.ui.timetable;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.DoubleClass;
import ru.vsu.math.java.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Дмитрий on 09.03.14.
 */
public class DeleteDoubleClassWindow extends JFrame implements ActionListener {
    private JButton deleteDoubleClass;
    private JComboBox deleteDoubleClassComboBox;
    private Application app;
    public DeleteDoubleClassWindow(Application app){
        super("Удаление пары");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<DoubleClass>doubleClasses = app.getDoubleClasses();
        DoubleClassesComboBoxModel model = new DoubleClassesComboBoxModel(doubleClasses);
        deleteDoubleClassComboBox = new JComboBox(model);
        deleteDoubleClass = new JButton("Удалить пару");
        deleteDoubleClass.addActionListener(this);
        JPanel deleteStudentPanel = new JPanel(new GridLayout(0, 1));
        deleteStudentPanel.add(deleteDoubleClass);
        deleteStudentPanel.add(deleteDoubleClassComboBox);
        add(deleteStudentPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        DoubleClass doubleClass;
        if (src == deleteDoubleClass) {
             int selectedIndex = deleteDoubleClassComboBox.getSelectedIndex();
             deleteDoubleClassComboBox.removeItemAt(selectedIndex);
             doubleClass = (DoubleClass)app.getDoubleClasses().get(selectedIndex);
             app.deleteDoubleClass(doubleClass);
             this.setVisible(false);
        }

    }
}
