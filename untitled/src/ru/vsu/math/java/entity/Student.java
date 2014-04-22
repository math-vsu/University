package ru.vsu.math.java.entity;
import ru.vsu.math.java.entity.Group;
import ru.vsu.math.java.*;

import java.security.PublicKey;
import java.sql.*;

public class Student extends SQLRecord {
  private String fullName;
  private Integer studentId;
  private Integer groupId;

  public Student(String fullName, Integer groupId, Integer studentId) {
    this.fullName = fullName;
    this.studentId = studentId;
    this.groupId = groupId;
  };

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Integer id(){
      return getStudentId();
  }
  public Integer getStudentId() {
    return this.studentId;
  }

  public Integer getGroupId() {
    return this.groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Group getGroup(){
      Group group = null;
      for(Object object : Application.getInstance().getGroups()){
          Group currentGroup = (Group) object;
          if (currentGroup.getGroupId() == this.getGroupId()) {
              group = currentGroup;
              break;
          }
      }
      return group;
  }
  @Override
  protected String tableName() {
    return "students";
  }

  @Override
  protected String columnNames() {
    return "(fullname, group_id)";
  }

  @Override
  protected String values() {
    return "('" + fullName + "', '" + groupId + "')";
  }

  @Override
  protected void buildObject(ResultSet row) {
    try {
      Application.getInstance().addStudent(row.getString("fullname"),row.getInt("group_id"), row.getInt("id"));
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public  String toString(){
      return getFullName();
  }
  @Override
  protected String updateString(){
     return "fullName= '"+this.fullName+"', group_id= '"+this.groupId+"'";
  }
}
