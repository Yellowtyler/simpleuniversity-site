package com.example.universitysite.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    public TeacherRepository teacherRepository;

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }


}
