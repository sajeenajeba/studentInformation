package com.studentdetail.studentdetaildemo.repository;

import com.studentdetail.studentdetaildemo.entity.StudEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudRepository extends MongoRepository<StudEntity, String> {

}
