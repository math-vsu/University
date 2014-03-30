package ru.vsu.math.java.entity;
import java.sql.*;

public abstract class SQLRecord implements Savable {
  public static final String dbName = "university";
  protected abstract String columnNames();
  protected abstract String values();
  protected abstract String tableName();
  protected abstract void buildObject(ResultSet row);
  protected abstract Integer id();
  protected abstract String updateString();

  public void loadCollection() {
    try {
      String query = "SELECT * FROM students";
      Statement stmt = null;
      stmt = DbConnection.get(dbName).createStatement();
      ResultSet rs = stmt.executeQuery(query);

      while(rs.next()) {
        buildObject(rs);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  public void save() {
    try {
      String query =
        "INSERT INTO " + tableName()
        + " " + columnNames() + " VALUES "
        + values();

      Statement stmt = null;
      stmt = DbConnection.get(dbName).createStatement();
      stmt.executeUpdate(query);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void delete(){
      try {
            String query =
                  "DELETE FROM " + tableName() + " WHERE id= " + id();

          Statement stmt = null;
          stmt = DbConnection.get(dbName).createStatement();
          stmt.executeUpdate(query);
      } catch(Exception e) {
          e.printStackTrace();
      }
  }

  public void update(){
      try {
          String query =
                  "UPDATE " + tableName() + " SET " + updateString()+ " WHERE id=" + id();

          Statement stmt = null;
          stmt = DbConnection.get(dbName).createStatement();
          stmt.executeUpdate(query);
      } catch(Exception e) {
          e.printStackTrace();
      }
  }
}
