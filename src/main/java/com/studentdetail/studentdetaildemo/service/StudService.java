package com.studentdetail.studentdetaildemo.service;

import com.studentdetail.studentdetaildemo.repository.StudRepository;
import com.studentdetail.studentdetaildemo.entity.StudEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudService {

    @Autowired
    private StudRepository studRepository;

    public List<StudEntity> getAllStudents() {
        List<StudEntity> sorted=studRepository.findAll().stream()
                .sorted(Comparator.comparing(StudEntity::getName))
                .collect(Collectors.toList());
        return sorted;
    }
    public String createStudentDetails(StudEntity studEntity) {
        studRepository.insert(studEntity);
        return "created successfully";

    }
    public String deleteStudent(String name) {
        studRepository.deleteByName(name);
        return "Deleted Successfully";
    }
}
