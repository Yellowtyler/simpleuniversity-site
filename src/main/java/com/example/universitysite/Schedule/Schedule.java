package com.example.universitysite.Schedule;

import com.example.universitysite.Teacher.Teacher;

import javax.persistence.*;

@Entity
@Table(name = "Schedule")
public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @Column
    private String gr;
    @Column
    private String name;
    @Column
    private String day;
    @Column
    private int week;
    @Column
    private int time;
    @Column
    private String type;
    @Column
    private String aud;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
  public Schedule()
   {

   }

    public int getId() {
        return id;
    }
    public String getGr() {
        return gr;
    }

    public void setGr(String gr) {
        this.gr= gr;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }



}
