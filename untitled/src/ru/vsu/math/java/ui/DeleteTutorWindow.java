package ru.vsu.math.java.ui;

import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Дмитрий on 03.04.14.
 */
public class DeleteTutorWindow extends JFrame implements ActionListener {
    private JButton deleteTutor;
    private JComboBox deleteTutorComboBox;
    private Application app;
    public DeleteTutorWindow(Application app){
        super("Удаление преподавателя");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Tutor> tutors = app.getTutors();
        TutorsComboBoxModel model = new TutorsComboBoxModel(tutors);
        deleteTutorComboBox = new JComboBox(model);
        deleteTutor = new JButton("Удалить преподавателя");
        deleteTutor.addActionListener(this);
        JPanel deleteTutorPanel = new JPanel(new GridLayout(0, 1));
        deleteTutorPanel.add(deleteTutor);
        deleteTutorPanel.add(deleteTutorComboBox);
        add(deleteTutorPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Tutor tutor;
        if (src == deleteTutor) {
            int selectedIndex = deleteTutorComboBox.getSelectedIndex();
            deleteTutorComboBox.removeItemAt(selectedIndex);
            tutor = (Tutor)app.getTutors().get(selectedIndex);
            app.deleteTutor(tutor);
        }

    }
}
