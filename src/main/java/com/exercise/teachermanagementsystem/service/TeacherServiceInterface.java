package com.exercise.teachermanagementsystem.service;

import com.exercise.teachermanagementsystem.entity.Teacher;

import java.util.List;

public interface TeacherServiceInterface {

    public List<Teacher> findAll();

    public Teacher findById(Long id);

    public Teacher save(Teacher teacher);

    public void deleteByID(Long id);

}
