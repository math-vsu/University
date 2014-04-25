package ru.vsu.math.java;
import ru.vsu.math.java.entity.*;
import java.sql.*;

public class Seeder {
  public static void createData(Application app) {
    createTables();
    seedRecords(app);
  };

  public static void createTables() {
    try {
      String[] table_schemas = {
        "create table " +
        "students" +
        "(id integer auto_increment NOT NULL, " +
        "fullname varchar(255) NOT NULL, " +
        "group_id integer NOT NULL, " +
        "PRIMARY KEY (id));",

        "create table " +
        "tutors" +
        "(id integer auto_increment NOT NULL, " +
        "fullname varchar(255) NOT NULL, " +
        "PRIMARY KEY (id));",

         "create table " +
         "groups" +
         "(id integer auto_increment NOT NULL, " +
         "course varchar(255) NOT NULL, " +
         "group_num varchar(255) NOT NULL, " +
         "subgroup varchar(255) NOT NULL, " +
         "degree varchar(255) NOT NULL, " +
         "PRIMARY KEY (id));",
      };

      for (String table_schema : table_schemas) {
        Statement stmt = null;
        try {
          stmt = DbConnection.get(SQLRecord.dbName).createStatement();
          stmt.executeUpdate(table_schema);
        } catch(SQLException e) {
          e.printStackTrace();
        } finally {
          if (stmt != null) { stmt.close(); }
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void seedRecords(Application app) {
     String[] studentNames = {
      "Соловьев Дмитрий Николаевич",
      "Савенков Михаил Владиславович",
      "Новоселов Антон Григорьевич",
      "Шипилов Алексей Владимирович",
      "Шилин Семен Иванович",
      "Микляев Владислав Иванович",
      "Измайлова Марина Анатольевна",
      "Щеблыкина Ирина Владимировна",
      "Кольцова Карелия Бенедиктовна",
      "Ляхов Владислав Иванович"
    };

    String[] tutorNames = {
        "Каменский",
        "Смагин",
        "Новиков"
    };

    if (app.getGroups().isEmpty()) {
        app.createGroup("2", "3", "2","bachelor");
        app.createGroup("1", "1", "1","master");
    }

    if (app.getTutors().isEmpty()) {
      for (String name : tutorNames) {
          app.createTutor(name, 1);
      }
    }

    // Создаем студентов, только если их список пуст
    // A cписок бывает пустым только когда в файле ничего нет
    if (app.getStudents().isEmpty()) {
      for (String name : studentNames) {
        app.createStudent(name, null, 0);
      }
    }

  }

}
