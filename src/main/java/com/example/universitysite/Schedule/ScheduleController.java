package com.example.universitysite.Schedule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;


import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.*;

@Controller
public class ScheduleController {

    @Autowired
ScheduleService scheduleService;



    @GetMapping(value = "/schedule")
    public String schedule(Model model) throws IOException {
        Iterable<Schedule> schedules = scheduleService.findAll();
        decode(schedules);
        model.addAttribute("schedules", schedules);

        return "schedule";
    }

    @RequestMapping( value = "/schedule")
    public String findGr(@RequestParam String group,@RequestParam String day, @RequestParam Integer time, Model model) throws IOException {
       if(group.isEmpty())
       {
           model.addAttribute("error","Ошибка, введит номер своей группы!");


       }
       else {
           Iterable<Schedule> schedules;
           group = encode(group);

          if(day.isEmpty()&&time==null&&group.equals("*")) schedules =scheduleService.findAll();

          else if(day.isEmpty()&&time==null)
           {
             schedules = scheduleService.findbyGroup(group);

           }
           else if(time==null)
           {
               day=encode(day);
               schedules = scheduleService.findByGrAndDay(group, day);
           }
           else
           {
               day=encode(day);
               schedules=scheduleService.findByGrAndDayAndTime(group,day,time);

           }
           decode(schedules);
           model.addAttribute("schedules", schedules);
       }
          return "schedule";
    }









    private static void decode(Iterable<Schedule> schedules) throws IOException {

       Set<Integer> set = new HashSet<Integer>();
        for(Schedule s: schedules)
        {

            s.setGr(  new String(s.getGr().getBytes("cp1251"),"cp866"));
            s.setName(  new String(s.getName().getBytes("cp1251"),"cp866"));
            s.setDay(  new String(s.getDay().getBytes("cp1251"),"cp866"));
            s.setType(  new String(s.getType().getBytes("cp1251"),"cp866"));
            s.setAud(  new String(s.getAud().getBytes("cp1251"),"cp866"));

            if(!set.contains(s.getTeacher().getId()))
            {
                set.add(s.getTeacher().getId());
                s.getTeacher().setName(new String(s.getTeacher().getName().getBytes("cp1251"),"cp866"));
            }

        }


    }

    private static String encode(String str) throws UnsupportedEncodingException {
       return new String(str.getBytes("cp866"),"cp1251");

    }


}




