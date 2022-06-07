package com.studentdetail.studentdetaildemo.service;

import com.studentdetail.studentdetaildemo.repository.StudRepository;
import com.studentdetail.studentdetaildemo.entity.StudEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StudService {

    @Autowired
    private StudRepository studRepository;
    public String createStudentDetails(StudEntity studEntity) {

            int roll;
            List<StudEntity> studentList =studRepository.findAll().stream().collect(Collectors.toList());
            if (CollectionUtils.isEmpty(studentList)){
                roll = 1;
            }
            else {
                studentList.sort(Comparator.comparingInt(StudEntity::getRollNo).reversed());
                   roll =studentList.get(0).getRollNo() + 1;
            }
            studEntity.setRollNo(roll);
            studRepository.insert(studEntity);
            return "created Successfully";
    }

    public List<StudEntity> getAllStudents() {
        List<StudEntity> sorted=studRepository.findAll().stream()
                .sorted(Comparator.comparing(StudEntity::getName))
                .collect(Collectors.toList());
        return sorted;
    }

    public String deleteStudent(String id) {
        if(!StringUtils.hasText(id)) {
            studRepository.deleteById(id);
            return "Deleted Successfully";
        }
    return "not deleted";
    }
}
