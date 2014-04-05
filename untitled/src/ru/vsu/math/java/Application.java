package ru.vsu.math.java;
import ru.vsu.math.java.entity.*;
import java.util.*;
import java.io.*;

public class Application {
  private List<Student> students = new ArrayList<Student>();
  private List<Group> groups = new ArrayList<Group>();
  private List<Tutor> tutors = new ArrayList<Tutor>();

  private static Application instance = null;
  public static Application getInstance() {
    if (instance == null) {
      instance = new Application();
      instance.loadCollections();
    }
    return instance;
  }

  public Application() {
  }

  public void createStudent(String fullName, Group group, Integer studentId) {
    addStudent(fullName, group, studentId).save();
  }

  public void deleteStudent(Student student){
     students.remove(student);
     student.delete();
  }

  public Student addStudent(String fullName, Group group, Integer studentId) {
    Student student = new Student(fullName, group, studentId);
    students.add(student);
    return student;
  }

  public void createTutor(String fullName, Integer id){
      addTutor(fullName, id).save();
  }

  public void deleteTutor(Tutor tutor){
      tutors.remove(tutor);
      tutor.delete();
  }
  public Tutor addTutor(String fullName, Integer id) {
    Tutor tutor = new Tutor(fullName,id);
    tutors.add(tutor);
    return tutor;
  }

  public void createGroup(String courseNumber, String groupNumber, String subGroupNumber){
      addGroup(courseNumber,groupNumber,subGroupNumber).save();
  }
  public Group addGroup(String courseNumber, String groupNumber, String subGroupNumber) {
    Group group = new Group(courseNumber, groupNumber, subGroupNumber);
    groups.add(group);
    return group;
  }

  public List getStudents() {
    return this.students;
  }

  public List getTutors() {
    return this.tutors;
  }

  public List getGroups() {
    return this.groups;
  }

  public void updateStudent(Student student, String fullName){
      student.setFullName(fullName);
      student.update();
  }
  private void loadCollections() {
    loadStudents();
    loadTutors();
    loadGroups();
  }

  private void loadStudents() {
    // Грязный трюк, так делать не надо
    // напомнить объяснить почему
    Student studentLoader = new Student(null, null,null);
    studentLoader.loadCollection();
  }

    public void updateTutor(Tutor tutor, String fullName){
        tutor.setFullName(fullName);
        tutor.update();
    }

    private void loadTutors() {
        // Грязный трюк, так делать не надо
        // напомнить объяснить почему
        Tutor tutorLoader = new Tutor(null, null);
        tutorLoader.loadCollection();
    }

    private void loadGroups() {
        // Грязный трюк, так делать не надо
        // напомнить объяснить почему
        Group groupLoader = new Group(null, null,null);
        groupLoader.loadCollection();
    }



}
