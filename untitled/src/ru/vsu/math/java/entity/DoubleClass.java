package ru.vsu.math.java.entity;

public class DoubleClass {
  private Integer groupId;
  private Integer weekday;
  private Integer doubleClassNumber;
  private Integer tutorId;

  public DoubleClass(Integer groupId, Integer weekday, Integer doubleClassNumber, Integer tutorId) {
    this.groupId = groupId;
    this.weekday = weekday;
    this.doubleClassNumber = doubleClassNumber;
    this.tutorId = tutorId;
  }

  public Integer getGroupId() {
    return this.groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Integer getWeekday() {
    return this.weekday;
  }

  public void setWeekday(Integer weekday) {
    this.weekday = weekday;
  }

  public Integer getDoubleClassNumber() {
    return this.doubleClassNumber;
  }

  public void setDoubleClassNumber(Integer doubleClassNumber) {
    this.doubleClassNumber = doubleClassNumber;
  }

  public Integer getTutorId() {
    return this.groupId;
  }

  public void setTutorId(Integer tutorId) {
    this.tutorId = tutorId;
  }
}
