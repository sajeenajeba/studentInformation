package com.studentdetail.studentdetaildemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("students")
public class StudEntity {
    @Id
    private String id;
    @Field(name="name")
    @Indexed
    private String name;
    @Field(name="dob")
    private String dob;
    @Field(name="standard")
    private String standard;
    @Field(name="division")
    private String division;
    @Field(name="gender")
    private String gender;
    @Field(name ="rollNo")
    private int rollNo;

}
