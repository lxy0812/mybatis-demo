package com.cy.pj.mybatis.pojo;

public class Student {
    private Integer id;
    private String name;
    private String gender;

    private String course;
    private Double score;

    public Student() {
        System.out.println("Student()...");
    }

    public Student(Integer id, String name, String gender, String course, Double score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.score = score;
    }

    public Integer getId() {
        System.out.println("getId()...");
        return id;
    }

    public void setId(Integer id) {
        System.out.println("setId()...id: " + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("getName()...");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName()...name: " + name);
        this.name = name;
    }

    public String getGender() {
        System.out.println("getGender()...");
        return gender;
    }

    public void setGender(String gender) {
        System.out.println("setGender()...gender: " + gender);
        this.gender = gender;
    }

    public String getCourse() {
        System.out.println("getCourse()...");
        return course;
    }

    public void setCourse(String course) {
        System.out.println("setCourse()...course" + course);
        this.course = course;
    }

    public Double getScore() {
        System.out.println("getScore()...");
        return score;
    }

    public void setScore(Double score) {
        System.out.println("setScore()...score" + score);
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
