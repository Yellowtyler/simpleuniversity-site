package com.example.universitysite.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


@Service
public class ScheduleServiceImp implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Iterable<Schedule> findbyGroup(String group) {
        return scheduleRepository.findAllByGr(group);
    }

    @Override
    public Iterable<Schedule> findByGrAndDay(String group, String day) {
        return scheduleRepository.findByGrAndDay(group, day);
    }

    @Override
    public Iterable<Schedule> findByGrAndDayAndTime(String group, String day, Integer time) {
        return scheduleRepository.findByGrAndDayAndTime(group,day,time);
    }

    @Override
    public Iterable<Schedule> findAll() {
        return scheduleRepository.findAll();
    }
}
