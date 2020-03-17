package com.example.universitysite.Schedule;

import java.util.Collection;
import java.util.List;

public interface ScheduleService {

  Iterable<Schedule> findAll();
  Iterable<Schedule> findbyGroup(String group);
  Iterable<Schedule> findByGrAndDay(String group, String day);
  Iterable<Schedule> findByGrAndDayAndTime(String group, String day, Integer time);
}
