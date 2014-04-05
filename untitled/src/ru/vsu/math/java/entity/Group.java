package ru.vsu.math.java.entity;

import ru.vsu.math.java.Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Group extends SQLRecord{
  private String courseNumber;
  private String groupNumber;
  private String subGroupNumber;

  public Group(String courseNumber, String groupNumber, String subGroupNumber) {
    this.courseNumber = courseNumber;
    this.groupNumber = groupNumber;
    this.subGroupNumber = subGroupNumber;
  }

  public String getCourseNumber() {
    return this.courseNumber;
  }

  public void setCourseNumber(String courseNumber) {
    this.courseNumber = courseNumber;
  }

  public String getGroupNumber() {
    return this.groupNumber;
  }

  public void setGroupNumber(String groupNumber) {
    this.groupNumber = groupNumber;
  }

  public String getSubGroupNumber() {
    return this.subGroupNumber;
  }

  public void setSubGroupNumber(String subGroupNumber) {
    this.courseNumber = subGroupNumber;
  }

  public String toString() {
    return this.courseNumber + "." + this.groupNumber + "." + this.subGroupNumber;
  }

    @Override
    protected String columnNames() {
        return "(course,group,subgroup)";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected String values() {
        return "('" + courseNumber + "', '" + groupNumber + "', '" + subGroupNumber + "')";
    }

    @Override
    protected String tableName() {
        return "groups";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void buildObject(ResultSet row) {
        try {
            Application.getInstance().addGroup(row.getString("course"), row.getString("group"), row.getString("subgroup"));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Integer id() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected String updateString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
