package ru.vsu.math.java.entity;

import ru.vsu.math.java.Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tutor extends SQLRecord{
  private String fullName;
  private Integer tutorId;

  public Tutor(String fullName, Integer tutorId) {
    this.fullName=fullName;
    this.tutorId=tutorId;
  }

  public Integer id(){
        return getTutorId();
  }

  public Integer getTutorId() {
        return this.tutorId;
    }
  public String getFullName() {
    return this.fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }


    @Override
    protected String columnNames() {
        return "(fullname)";
    }

    @Override
    protected String values() {
        return "('" + fullName + "')";
    }

    @Override
    protected String tableName() {
        return "tutors";
    }

    @Override
    protected void buildObject(ResultSet row) {
        try {
            Application.getInstance().addTutor(row.getString("fullname"), row.getInt("id"));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public  String toString(){
        return getFullName();
    }

    @Override
    protected String updateString() {
        return "fullName= '"+this.fullName+"'";
    }
}
