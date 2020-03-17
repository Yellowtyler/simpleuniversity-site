package com.example.universitysite.Teacher;


import javax.persistence.*;

@Entity
@Table(name="Teacher")
public class Teacher {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String rank;
    @Column
    private String kafedra;


  public   Teacher()
    {

    }
    public int getId() {
        return id;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getKafedra() {
        return kafedra;
    }

    public void setKafedra(String kafedra) {
        this.kafedra = kafedra;
    }


}
