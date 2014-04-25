package ru.vsu.math.java.ui.tutors;

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
public class EditTutorWindow extends JFrame implements ActionListener {
    private Application app;
    private JButton updateTutor;
    private JTextField tutorNewFullNameField;
    private JComboBox editTutorComboBox;

    public EditTutorWindow(Application app){
        super("Редактирование преподавателя");
        setBounds(100, 100, 700, 700);
        this.app = app;
        List<Tutor> tutors = app.getTutors();
        TutorsComboBoxModel model = new TutorsComboBoxModel(tutors);
        editTutorComboBox = new JComboBox(model);
        tutorNewFullNameField = new JTextField(20);
        updateTutor = new JButton("Обновить данные");
        updateTutor.addActionListener(this);
        editTutorComboBox.addActionListener(this);
        JPanel editTutorPanel = new JPanel(new GridLayout(0,1));
        editTutorPanel.add(editTutorComboBox);
        editTutorPanel.add(tutorNewFullNameField);
        editTutorPanel.add(updateTutor);
        add(editTutorPanel, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        Tutor tutor;
        if(src == editTutorComboBox){
            tutorNewFullNameField.setText(editTutorComboBox.getSelectedItem().toString());
        }

        if(src == updateTutor){
            int selectedIndex = editTutorComboBox.getSelectedIndex();
            tutor = (Tutor)app.getTutors().get(selectedIndex);
            app.updateTutor(tutor, tutorNewFullNameField.getText());
            this.setVisible(false);
        }
    }
}
