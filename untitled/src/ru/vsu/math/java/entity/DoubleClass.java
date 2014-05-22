package ru.vsu.math.java.entity;

import ru.vsu.math.java.Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoubleClass extends SQLRecord{
  private Integer groupId;
  private Integer tutorId;
  private Integer weekday;
  private Integer number;
  private String classroom;


  public DoubleClass(Integer groupId, Integer tutorId, Integer weekday, Integer number, String classroom) {
    this.groupId = groupId;
    this.tutorId = tutorId;
    this.weekday = weekday;
    this.number = number;
    this.classroom = classroom;
  }

  public Integer getGroupId() {
    return this.groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Integer getTutorId() {
        return this.groupId;
  }

  public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
  }

  public Integer getWeekday() {
    return this.weekday;
  }

  public void setWeekday(Integer weekday) {
    this.weekday = weekday;
  }

  public Integer getNumber() {
    return this.number;
  }

  public void setNumber(Integer doubleClassNumber) {
    this.number = number;
  }

  public String getClassroom(){
      return this.classroom;
  }

  public void setClassroom(String classroom){
     this.classroom = classroom;
  }


    @Override
    protected String columnNames() {
        return "(group_id,tutor_id,weekday,number,classroom)";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected String values() {
        return "('" + groupId + "', '" + tutorId + "', '" + weekday + "', '" + number + "', '" + classroom + "')";
    }

    @Override
    protected String tableName() {
        return "doubleclasses";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void buildObject(ResultSet row) {
        try {
            Application.getInstance().addDoubleClass(row.getInt("group_id"),row.getInt("tutor_id"), row.getInt("weekday"),row.getInt("number"),row.getString("class"));
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
        return "group_id='"+this.groupId+"', tutor_id='"+this.tutorId+"', weekday='"+this.weekday+"', number='"+this.number+"', classroom='"+this.classroom+"'";
    }
}
