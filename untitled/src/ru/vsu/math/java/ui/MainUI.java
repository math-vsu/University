package ru.vsu.math.java.ui;
import ru.vsu.math.java.Application;
import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.ui.groups.*;
import ru.vsu.math.java.ui.students.AddStudentWindow;
import ru.vsu.math.java.ui.students.DeleteStudentWindow;
import ru.vsu.math.java.ui.students.EditStudentWindow;
import ru.vsu.math.java.ui.students.StudentsWindow;
import ru.vsu.math.java.ui.timetable.AddDoubleClassWindow;
import ru.vsu.math.java.ui.timetable.DeleteDoubleClassWindow;
import ru.vsu.math.java.ui.timetable.DoubleClassesWindow;
import ru.vsu.math.java.ui.timetable.EditDoubleClassWindow;
import ru.vsu.math.java.ui.tutors.AddTutorWindow;
import ru.vsu.math.java.ui.tutors.DeleteTutorWindow;
import ru.vsu.math.java.ui.tutors.EditTutorWindow;
import ru.vsu.math.java.ui.tutors.TutorsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//класс отвечает за всю графическую оболочку
public class MainUI extends JFrame {
    private Application app;
    private StudentsWindow studentsWindow;
    private AddStudentWindow addStudentWindow;
    private DeleteStudentWindow deleteStudentWindow;
    private EditStudentWindow editStudentWindow;

    private TutorsWindow tutorsWindow;
    private AddTutorWindow addTutorWindow;
    private DeleteTutorWindow deleteTutorWindow;
    private EditTutorWindow editTutorWindow;

    private GroupsWindow groupsWindow;
    private AddGroupWindow addGroupWindow;
    private DeleteGroupWindow deleteGroupWindow;
    private EditGroupWindow editGroupWindow;

    private DoubleClassesWindow  doubleClassesWindow;
    private AddDoubleClassWindow addDoubleClassWindow;
    private DeleteDoubleClassWindow deleteDoubleClassWindow;
    private EditDoubleClassWindow editDoubleClassWindow;

    private JMenu firstCourse;
    private JMenu secondCourse;

    private JMenu firstCourseM;
    private JMenu secondCourseM;

    private java.util.List<GroupMenuItem> groupMenuItems = new ArrayList<GroupMenuItem>();


    public MainUI(Application app) {
        super("University"); //Заголовок окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.app = app;

        studentsWindow = new StudentsWindow(app);
        addStudentWindow = new AddStudentWindow(app);
        deleteStudentWindow = new DeleteStudentWindow(app);
        editStudentWindow = new EditStudentWindow(app);

        tutorsWindow = new TutorsWindow(app);
        addTutorWindow = new AddTutorWindow(app);
        deleteTutorWindow = new DeleteTutorWindow(app);
        editTutorWindow = new EditTutorWindow(app);

        groupsWindow = new GroupsWindow(app);
        addGroupWindow = new AddGroupWindow(app);
        deleteGroupWindow = new DeleteGroupWindow(app);
        editGroupWindow = new EditGroupWindow(app);

        doubleClassesWindow  = new DoubleClassesWindow(app);
        addDoubleClassWindow = new AddDoubleClassWindow(app);
        deleteDoubleClassWindow = new DeleteDoubleClassWindow(app);
        editDoubleClassWindow = new EditDoubleClassWindow(app);

        setBounds(400, 400, 400, 400); //Если не выставить размер и положение - то окно будет мелкое и незаметное

        //-------------------------Меню---------------------------------------------------//
        JMenuBar mainMenuBar = new JMenuBar();
        Font font = new Font("Verdana", Font.PLAIN, 11);

        //------------------------Меню Файл------------------------------------------//
        JMenu fileMenu = new JMenu("Файл");
        fileMenu.setFont(font);

        JMenuItem connectServerItem = new JMenuItem("Подключиться к серверу");
        connectServerItem.setFont(font);
        fileMenu.add(connectServerItem);

        JMenuItem importStudentsItem = new JMenuItem("Импортировать список студентов");
        importStudentsItem.setFont(font);
        fileMenu.add(importStudentsItem);

        JMenuItem importTutorsItem = new JMenuItem("Импортировать список преподавателей");
        importTutorsItem.setFont(font);
        fileMenu.add(importTutorsItem);

        JMenuItem settingsItem = new JMenuItem("Настройки");
        settingsItem.setFont(font);
        fileMenu.add(settingsItem);

        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.setFont(font);
        fileMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //------------------------Меню студентов------------------------------------------//
        JMenu studentsMenu = new JMenu("Студенты");
        studentsMenu.setFont(font);

        JMenuItem studentsListItem = new JMenuItem("Вывести список студентов");
        studentsListItem.setFont(font);
        studentsMenu.add(studentsListItem);
        studentsListItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentsWindow.setVisible(true);
            }
        });

        JMenuItem addStudentItem = new JMenuItem("Добавить студента");
        addStudentItem.setFont(font);
        studentsMenu.add(addStudentItem);
        addStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudentWindow.setVisible(true);
            }
        });

        JMenuItem editStudentItem = new JMenuItem("Редактировать студента");
        editStudentItem.setFont(font);
        studentsMenu.add(editStudentItem);
        editStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editStudentWindow.setVisible(true);
            }
        });

        JMenuItem deleteStudentItem = new JMenuItem("Удалить студента");
        deleteStudentItem.setFont(font);
        studentsMenu.add(deleteStudentItem);
        deleteStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudentWindow.setVisible(true);
            }
        });

        //------------------------Меню преподавателей------------------------------------------//
        JMenu tutorsMenu = new JMenu("Преподаватели");
        tutorsMenu.setFont(font);

        JMenuItem tutorsListItem = new JMenuItem("Вывести список преподавателей");
        tutorsListItem.setFont(font);
        tutorsMenu.add(tutorsListItem);
        tutorsListItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tutorsWindow.setVisible(true);
            }
        });

        JMenuItem addTutorItem = new JMenuItem("Добавить преподавателя");
        addTutorItem.setFont(font);
        tutorsMenu.add(addTutorItem);
        addTutorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTutorWindow.setVisible(true);
            }
        });

        JMenuItem editTutorItem = new JMenuItem("Редактировать преподавателя");
        editTutorItem.setFont(font);
        tutorsMenu.add(editTutorItem);
        editTutorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editTutorWindow.setVisible(true);
            }
        });

        JMenuItem deleteTutorItem = new JMenuItem("Удалить преподавателя");
        deleteTutorItem.setFont(font);
        tutorsMenu.add(deleteTutorItem);
        deleteTutorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTutorWindow.setVisible(true);
            }
        });

        //------------------------Меню Групп------------------------------------------//
        JMenu groupsMenu = new JMenu("Группы");
        groupsMenu.setFont(font);

        //****************************************************//
        JMenu groupsList = new JMenu("Вывести список групп");
        groupsList.setFont(font);
        groupsMenu.add(groupsList);

        JMenu bachelorMenu = new JMenu("Бакалавры/Специалисты");
        bachelorMenu.setFont(font);
        groupsList.add(bachelorMenu);

        firstCourse = new JMenu("1 курс");
        firstCourse.setFont(font);
        bachelorMenu.add(firstCourse);


        secondCourse = new JMenu("2 курс");
        secondCourse.setFont(font);
        bachelorMenu.add(secondCourse);

        JMenu thirdCourse = new JMenu("3 курс");
        thirdCourse.setFont(font);
        bachelorMenu.add(thirdCourse);

        JMenu fourthCourse = new JMenu("4 курс");
        fourthCourse.setFont(font);
        bachelorMenu.add(fourthCourse);

        JMenu fifthCourse = new JMenu("5 курс");
        fifthCourse.setFont(font);
        bachelorMenu.add(fifthCourse);

        //****************************************************//

        JMenu magisterMenu = new JMenu("Магистры");
        magisterMenu.setFont(font);
        groupsList.add(magisterMenu);

        firstCourseM = new JMenu("1 курс");
        firstCourseM.setFont(font);
        magisterMenu.add(firstCourseM);

        secondCourseM = new JMenu("2 курс");
        secondCourseM.setFont(font);
        magisterMenu.add(secondCourseM);

        JMenuItem addGroupItem = new JMenuItem("Добавить группу");
        addGroupItem.setFont(font);
        groupsMenu.add(addGroupItem);
        addGroupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addGroupWindow.setVisible(true);
            }
        });

        JMenuItem editGroupItem = new JMenuItem("Редактировать группу");
        editGroupItem.setFont(font);
        groupsMenu.add(editGroupItem);
        editGroupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editGroupWindow.setVisible(true);
            }
        });

        JMenuItem deleteGroupItem = new JMenuItem("Удалить группу");
        deleteGroupItem.setFont(font);
        groupsMenu.add(deleteGroupItem);
        deleteGroupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteGroupWindow.setVisible(true);
            }
        });

        JMenuItem allGroups = new JMenuItem("Все группы");
        allGroups.setFont(font);
        groupsMenu.add(allGroups);
        allGroups.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    groupsWindow.setVisible(true);

            }
        });

        //------------------------Меню Расписание------------------------------------------//
        JMenu timeTable = new JMenu("Расписание");
        timeTable.setFont(font);

        JMenu bachelorTimeTableMenu = new JMenu("Бакалавры/Специалисты");
        bachelorTimeTableMenu.setFont(font);
        timeTable.add(bachelorTimeTableMenu);

        JMenuItem firstCourseTimeTable = new JMenuItem("1 курс");
        firstCourseTimeTable.setFont(font);
        bachelorTimeTableMenu.add(firstCourseTimeTable);

        JMenuItem secondCourseTimeTable = new JMenuItem("2 курс");
        secondCourseTimeTable.setFont(font);
        bachelorTimeTableMenu.add(secondCourseTimeTable);

        JMenuItem thirdCourseTimeTable = new JMenuItem("3 курс");
        thirdCourseTimeTable.setFont(font);
        bachelorTimeTableMenu.add(thirdCourseTimeTable);

        JMenuItem fourthCourseTimeTable = new JMenuItem("4 курс");
        fourthCourseTimeTable.setFont(font);
        bachelorTimeTableMenu.add(fourthCourseTimeTable);

        JMenuItem fifthCourseTimeTable = new JMenuItem("5 курс");
        fifthCourseTimeTable.setFont(font);
        bachelorTimeTableMenu.add(fifthCourseTimeTable);

        //************************************************//
        JMenu magisterTimeTableMenu = new JMenu("Магистры");
        magisterTimeTableMenu.setFont(font);
        timeTable.add(magisterTimeTableMenu);

        JMenuItem firstCourseMtimeTable = new JMenuItem("1 курс");
        firstCourseMtimeTable.setFont(font);
        magisterTimeTableMenu.add(firstCourseMtimeTable);

        JMenuItem secondCourseMtimeTable = new JMenuItem("2 курс");
        secondCourseMtimeTable.setFont(font);
        magisterTimeTableMenu.add(secondCourseMtimeTable);

        //------------------------------//
        JMenuItem doubleClassesItem = new JMenuItem("Список пар");
        doubleClassesItem.setFont(font);
        timeTable.add(doubleClassesItem);
        doubleClassesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doubleClassesWindow.setVisible(true);
            }
        });

        JMenuItem addDoubleClassesItem = new JMenuItem("Добавить пару");
        addDoubleClassesItem.setFont(font);
        timeTable.add(addDoubleClassesItem);
        addDoubleClassesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDoubleClassWindow.setVisible(true);
            }
        });

        JMenuItem deleteDoubleClassesItem = new JMenuItem("Удалить пару");
        deleteDoubleClassesItem.setFont(font);
        timeTable.add(deleteDoubleClassesItem);
        deleteDoubleClassesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDoubleClassWindow.setVisible(true);
            }
        });

        JMenuItem editDoubleClassItem = new JMenuItem("Редактировать пару");
        editDoubleClassItem.setFont(font);
        timeTable.add(editDoubleClassItem);
        editDoubleClassItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editDoubleClassWindow.setVisible(true);
            }
        });

        JMenuItem editTimeTableItem = new JMenuItem("Редактировать расписание");
        editTimeTableItem.setFont(font);
        timeTable.add(editTimeTableItem);


        for(Object group: app.getGroups()){
            GroupMenuItem  newMenuItem = new GroupMenuItem(group.toString(),(Group)group);
            groupMenuItems.add(newMenuItem);
            addItemToGroupsMenu(newMenuItem);
        }

        //Располагаем все меню на главном баре
        mainMenuBar.add(fileMenu);
        mainMenuBar.add(studentsMenu);
        mainMenuBar.add(tutorsMenu);
        mainMenuBar.add(groupsMenu);
        mainMenuBar.add(timeTable);
        this.add(mainMenuBar);
        this.setJMenuBar(mainMenuBar);
    }

    public void addItemToGroupsMenu(GroupMenuItem groupMenuItem){
        if(groupMenuItem.getGroup().getDegree()== "bachelor"){
             switch (groupMenuItem.getGroup().getCourseNumber().charAt(0)){
                 case '1':  firstCourse.add(groupMenuItem); break;
                 case '2':  secondCourse.add(groupMenuItem); break;
                 default: break;
             }
        }

        else {
              if (groupMenuItem.getGroup().getDegree()== "master"){
                  switch(groupMenuItem.getGroup().getCourseNumber().charAt(0)){
                      case '1':  firstCourseM.add(groupMenuItem) ;break;
                      case '2':  secondCourseM.add(groupMenuItem);break;
                      default: break;
                  }
              }
        }
    }
}
