package ru.vsu.math.java.entity;

public class Group {
  private Integer courseNumber;
  private Integer groupNumber;
  private Integer subGroupNumber;

  public Group(Integer courseNumber, Integer groupNumber, Integer subGroupNumber) {
    this.courseNumber = courseNumber;
    this.groupNumber = groupNumber;
    this.subGroupNumber = subGroupNumber;
  }

  public Integer getCourseNumber() {
    return this.courseNumber;
  }

  public void setCourseNumber(Integer courseNumber) {
    this.courseNumber = courseNumber;
  }

  public Integer getGroupNumber() {
    return this.groupNumber;
  }

  public void setGroupNumber(Integer groupNumber) {
    this.groupNumber = groupNumber;
  }

  public Integer getSubGroupNumber() {
    return this.subGroupNumber;
  }

  public void setSubGroupNumber(Integer subGroupNumber) {
    this.courseNumber = subGroupNumber;
  }

  public String toString() {
    return this.courseNumber + "." + this.groupNumber + "." + this.subGroupNumber;
  }
}
