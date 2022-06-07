package com.studentdetail.studentdetaildemo.controller;

import com.studentdetail.studentdetaildemo.entity.StudEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.studentdetail.studentdetaildemo.service.StudService;

@CrossOrigin("*")
@RequestMapping
@RestController
public class StudController {

    @Autowired
    private StudService studService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createStudent(@RequestBody StudEntity studEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studService.createStudentDetails(studEntity));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam String id) {
        return ResponseEntity.status(HttpStatus.OK).body(studService.deleteStudent(id));
    }

    @GetMapping(value = "/students")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studService.getAllStudents());
    }
}
