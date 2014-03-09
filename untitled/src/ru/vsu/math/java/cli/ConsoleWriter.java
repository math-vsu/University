package ru.vsu.math.java.cli;
import ru.vsu.math.java.*;
import ru.vsu.math.java.entity.*;
import java.util.*;

public class ConsoleWriter {
  private Application app;

  public ConsoleWriter(Application app) {
    this.app = app;
  }

  public void displayStudents() {
    List<Student> students = app.getStudents();
    for(Student student : students) {
      System.out.println(student.getStudentId() + " - " + student.getFullName());
    }
  }

  public void displayTutors() {
    List<Tutor> tutors = app.getTutors();
    for(Tutor tutor : tutors) {
      System.out.println(tutor.getFullName());
    }
  }

  public void displayGroups() {
    List<Group> groups  = app.getGroups();
    for(Group group : groups) {
      System.out.print(group.getCourseNumber() + ".");
      System.out.print(group.getGroupNumber() + ".");
      System.out.println(group.getSubGroupNumber());
    }
  }

  public void printRootMenu() {
    System.out.println("1 - Вывести студентов");
    System.out.println("2 - Вывести преподавателей");
    System.out.println("3 - Вывести группы");
    System.out.println("4 - Добавить студента");
    System.out.println("5 - Удалить студента");
  }

  public void printNewStudentPrompt(){
      System.out.println("Введите ФИО студента");
  }

  public void printDeleteStudentPrompt(){
      System.out.println("Введите id студента");
  }
}
