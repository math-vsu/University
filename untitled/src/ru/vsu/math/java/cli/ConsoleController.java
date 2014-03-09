package ru.vsu.math.java.cli;
import ru.vsu.math.java.*;
import ru.vsu.math.java.entity.*;

public class ConsoleController {
  private Application app;
  private ConsoleReader reader;
  private ConsoleWriter writer;
  private String[] doubleLevelMenu = {"4"};
  public ConsoleController(Application app) {
    this.app = app;
    this.reader = new ConsoleReader(app);
    this.writer = new ConsoleWriter(app);
  }

  public void run() {
    rootMenu();
  }

  private void rootMenu() {
    writer.printRootMenu();
    String result = reader.readRootMenuResult();
    runMenuAction(result);
  }

  public void runMenuAction(String result) {
    switch (result.charAt(0)) {
      case '1': writer.displayStudents(); break;
      case '2': writer.displayTutors(); break;
      case '3': writer.displayGroups(); break;
      case '4': newStudentDialog(); break;
      case '5': newDeleteStudentDialog(); break;
    }
    if(!isDoubleLevel(result)){
        rootMenu();
    }
  }

  private void addMenu() {
  }

  private void addStudent(Student student) {
  }

  private void displayStudent() {
  }

  private void newStudentDialog(){
      writer.printNewStudentPrompt();
      reader.readAndCreateStudent();
      rootMenu();
  }

  private void newDeleteStudentDialog(){
      writer.printDeleteStudentPrompt();
      reader.readAndDeleteStudent();
      rootMenu();
  };

  private boolean isDoubleLevel(String result){
      boolean res = false;
      for(String item: doubleLevelMenu ){
          if(item.charAt(0) == result.charAt(0)){
              res =true;
              break;
          }
      }

      return res;
  }
}
