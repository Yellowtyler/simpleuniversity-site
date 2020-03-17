package com.example.universitysite.Teacher;

public interface TeacherService {
    public Iterable<Teacher> findAll();
    public void save(Teacher teacher);
}
