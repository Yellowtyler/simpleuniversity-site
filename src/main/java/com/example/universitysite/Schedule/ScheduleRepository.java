package com.example.universitysite.Schedule;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

  @Query("SELECT e FROM Schedule e WHERE e.gr=:group")
  @Transactional(readOnly=true)
  Iterable<Schedule> findAllByGr(@Param("group")String group);

  @Query("SELECT e FROM Schedule e WHERE e.gr=:group and e.day=:day")
  @Transactional(readOnly=true)
  Iterable<Schedule> findByGrAndDay(@Param("group")String group, @Param("day")String day);

  @Query("SELECT e FROM Schedule e WHERE e.gr=:group AND e.day=:day AND e.time=:time")
  @Transactional(readOnly=true)
  Iterable<Schedule> findByGrAndDayAndTime(@Param("group")String group, @Param("day")String day,@Param("time") Integer time);

  Iterable<Schedule> findAll();
}
