package ru.vsu.math.java;
import ru.vsu.math.java.entity.DoubleClass;
import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.entity.Student;
import ru.vsu.math.java.entity.Tutor;

import java.util.ArrayList;
import java.util.List;

public class Application {
  private List<Student> students = new ArrayList<Student>();
  private List<Group> groups = new ArrayList<Group>();
  private List<Tutor> tutors = new ArrayList<Tutor>();
  private List<DoubleClass> doubleClasses = new ArrayList<DoubleClass>();

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

  public void createStudent(String fullName, Integer groupId, Integer studentId) {
    addStudent(fullName, groupId, studentId).save();
  }

  public void deleteStudent(Student student){
     students.remove(student);
     student.delete();
  }

  public Student addStudent(String fullName, Integer groupId, Integer studentId) {
    Student student = new Student(fullName, groupId, studentId);
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

  public void createGroup(String courseNumber, String groupNumber, String subGroupNumber,String degree){
      addGroup(null,courseNumber,groupNumber,subGroupNumber,degree).save();
  }
  public Group addGroup(Integer id,String courseNumber, String groupNumber, String subGroupNumber, String degree) {
    Group group = new Group(id,courseNumber, groupNumber, subGroupNumber,degree);
    groups.add(group);
    return group;
  }

  public void deleteGroup(Group group){
      groups.remove(group);
      group.delete();
  }

    public void createDoubleClass(Integer groupId, Integer tutorId, Integer weekday,Integer number, String classroom){
        addDoubleClass(groupId,tutorId, weekday, number, classroom).save();
    }
    public DoubleClass addDoubleClass(Integer groupId, Integer tutorId, Integer weekday,Integer number, String classroom) {
        DoubleClass doubleClass = new DoubleClass(groupId, tutorId, weekday, number, classroom);
        doubleClasses.add(doubleClass);
        return doubleClass;
    }

    public void deleteDoubleClass(DoubleClass doubleClass){
        doubleClasses.remove(doubleClass);
        doubleClass.delete();
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

  public List getDoubleClasses(){
      return this.doubleClasses;
  }

  public void updateStudent(Student student, String fullName, Integer groupId){
      student.setFullName(fullName);
      student.setGroupId(groupId);
      student.update();
  }
  private void loadCollections() {
    loadStudents();
    loadTutors();
    loadGroups();
    loadDoubleClasses();
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
    public void updateGroup(Group group, String courseNumber, String groupNumber,String subgroupNumber, String degree){
        group.setCourseNumber(courseNumber);
        group.setGroupNumber(groupNumber);
        group.setSubGroupNumber(subgroupNumber);
        group.setDegree(degree);
        group.update();
    }
    private void loadGroups() {
        // Грязный трюк, так делать не надо
        // напомнить объяснить почему
        Group groupLoader = new Group(null,null, null,null,null);
        groupLoader.loadCollection();
    }

    public void updateDoubleClass(DoubleClass doubleClass, Integer groupId, Integer tutorId, Integer weekday,Integer number, String classroom ){
        doubleClass.setGroupId(groupId);
        doubleClass.setTutorId(tutorId);
        doubleClass.setWeekday(weekday);
        doubleClass.setNumber(number);
        doubleClass.setClassroom(classroom);
        doubleClass.update();
    }
    private void loadDoubleClasses(){
        // Грязный трюк, так делать не надо
        // напомнить объяснить почему
        DoubleClass doubleClassLoader = new DoubleClass(null,null, null,null,null);
        doubleClassLoader.loadCollection();
    }



}
