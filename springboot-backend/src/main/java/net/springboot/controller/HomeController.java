package net.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.entity.Student;
import net.springboot.repository.StudentRepo;

@RestController
public class HomeController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/")
    public String index()
    {
        return("this is working !");
    }

    @PostMapping("/savestudent")
    public Student saveStudent(@RequestBody Student student)
    {
        studentRepo.save(student);
        return student;
    }

    @GetMapping("/getAllStudent")
    public List<Student> getall()
    {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    @DeleteMapping("/deleteStudent/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo)
    {
        Student student = studentRepo.findById(rollNo).get();
        if(student != null)
        {
            studentRepo.delete(student);
        }
        return "delete Sucessful";
    }
}
