package ru.vsu.math.java.entity;

public class Tutor {
  private String fullName;

  public Tutor(String fullName) {
    this.fullName=fullName;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}
