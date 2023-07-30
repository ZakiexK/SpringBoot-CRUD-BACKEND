package net.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.entity.Teacher;
import net.repository.RepoTeacher;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class controller {
    @Autowired
    private RepoTeacher repoTeacher;

    @GetMapping(value = "/getAllTecher")
    public List<Teacher> getAllTeacher()
    {
        List<Teacher> teacher = repoTeacher.findAll();
        return teacher;

    }
    
    @PostMapping(value="/saveTeacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        repoTeacher.save(teacher);    
        return teacher;
    }

    @GetMapping(value = "/getTeacher/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name)
    {
        Teacher teacher = repoTeacher.findByName(name);
        if(teacher == null)
        {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping(value = "/deleteTeacher/{id}")
    public String deleteTeacherById(@PathVariable int id)
    {
        Teacher teacher = repoTeacher.findById(id).get();
        if(teacher != null)
        {
            repoTeacher.delete(teacher);
        }
        return("Delete Successful");
    }

    @PostMapping(value = "/updateTeacher/{id}")
    public Teacher updateTeacher(@PathVariable int id,@RequestBody Teacher teacher)
    {
        Teacher exisitingTeacher = repoTeacher.findById(id).get();

        if(exisitingTeacher == null) 
        {
            ResponseEntity.notFound().build();
        }
        exisitingTeacher.setId(teacher.getId());
        exisitingTeacher.setName(teacher.getName());
        exisitingTeacher.setAddress(teacher.getAddress());

        repoTeacher.save(exisitingTeacher);

        return exisitingTeacher;
    }
    


    
    
}