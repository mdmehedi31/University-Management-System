package com.university.studentinfo.services.definition;

import com.university.studentinfo.dto.Request.RequestStudentInfo;
import com.university.studentinfo.dto.Respons.ResponsStudentInfo;
import com.university.studentinfo.entity.StudentEntity;

import java.util.List;

public interface StudentServiceDefinition {

    List<ResponsStudentInfo> getAllStudent();

    void saveStudent(RequestStudentInfo requestStudentInfo);

    void updateStudentInfo(String id, RequestStudentInfo requestStudentInfo);

    ResponsStudentInfo entityTodto(StudentEntity studentEntity);

    StudentEntity dtoToentity(RequestStudentInfo requestStudentInfo);
}
