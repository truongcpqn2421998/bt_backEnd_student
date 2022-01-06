package com.example.bt2.controller;

import com.example.bt2.model.Student;
import com.example.bt2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteBookById(@PathVariable Long id) {
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateBookById(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> findBookById(@PathVariable Long id) {

        return new ResponseEntity<>(studentService.findById(id).get(), HttpStatus.OK);
    }
}
