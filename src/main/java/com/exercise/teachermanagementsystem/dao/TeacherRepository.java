package com.exercise.teachermanagementsystem.dao;

import com.exercise.teachermanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    public List<Teacher> findAllByOrderByLastNameAsc();
}
