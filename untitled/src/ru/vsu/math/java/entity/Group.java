package ru.vsu.math.java.entity;

import ru.vsu.math.java.Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Group extends SQLRecord{
  private String courseNumber;
  private String groupNumber;
  private String subGroupNumber;
  private Integer groupId;
  private String degree;

  public Group(Integer groupId, String courseNumber, String groupNumber, String subGroupNumber, String degree) {
    this.groupId = groupId;
    this.courseNumber = courseNumber;
    this.groupNumber = groupNumber;
    this.subGroupNumber = subGroupNumber;
    this.degree = degree;
  }

  public Integer getGroupId(){
      return this.groupId;
  }

  public void setGroupId(Integer groupId){
      this.groupId = groupId;
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
    this.subGroupNumber = subGroupNumber;
  }

  public String name(){
      return this.courseNumber + "." + this.groupNumber + "." + this.subGroupNumber;
  }

    public String getDegree(){
        return this.degree;
    }
    public void  setDegree(String degree){
        this.degree = degree;
    }

  public String toString() {
    return name();
  }

    @Override
    protected String columnNames() {
        return "(course,group_num,subgroup,degree)";
    }

    @Override
    protected String values() {
        return "('" + courseNumber + "', '" + groupNumber + "', '" + subGroupNumber + "', '" + degree + "')";
    }

    @Override
    protected String tableName() {
        return "groups";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void buildObject(ResultSet row) {
        try {
            Application.getInstance().addGroup(row.getInt("id"), row.getString("course"), row.getString("group_num"), row.getString("subgroup"), row.getString("degree"));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Integer id() {
        return getGroupId();
    }

    @Override
    protected String updateString() {
        return "course='"+this.courseNumber+"', group_num='"+this.groupNumber+"', subgroup='"+this.subGroupNumber+"', degree='"+this.degree+"'";
    }
}
