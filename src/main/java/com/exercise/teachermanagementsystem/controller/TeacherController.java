package com.exercise.teachermanagementsystem.controller;


import com.exercise.teachermanagementsystem.entity.Teacher;
import com.exercise.teachermanagementsystem.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {


    private TeacherService teacherService;

    public TeacherController(TeacherService tService){
        this.teacherService = tService;
    }

    @GetMapping("/get")
    public String getTeachers(Model model){
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teachers", teacherList);
        return "teachers";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teacher-form";
    }

    @GetMapping("/updateTeacher")
    public String updateTeacher(@RequestParam("teacherId") Long id, Model model){
        Teacher teacher = teacherService.findById(id);
        model.addAttribute("teacher", teacher);
        return "teacher-form";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teachers/get";
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("teacherId") Long id){
        teacherService.deleteByID(id);
        return "redirect:/teachers/get";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(){
        teacherService.deleteAll();
        return "redirect:/teachers/get";
    }

}
