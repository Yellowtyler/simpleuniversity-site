package com.example.universitysite.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;


@org.springframework.stereotype.Controller

public class TeacherController {

    @Autowired
private TeacherService teacherService;


    @GetMapping("/teacher")
    public String teachers(Model model) throws UnsupportedEncodingException {
        Iterable<Teacher> teachers = teacherService.findAll();
        decode(teachers);
        model.addAttribute("teachers", teachers);

        return "teacher";
    }

    private static void decode(Iterable<Teacher> teachers) throws UnsupportedEncodingException {
        for(Teacher s: teachers)
        {

            s.setName(  new String(s.getName().getBytes("cp1251"),"cp866"));
            s.setKafedra(  new String(s.getKafedra().getBytes("cp1251"),"cp866"));
            s.setRank(  new String(s.getRank().getBytes("cp1251"),"cp866"));


        }


    }








}
