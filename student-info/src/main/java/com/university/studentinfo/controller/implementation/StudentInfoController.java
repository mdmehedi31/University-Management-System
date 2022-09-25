package com.university.studentinfo.controller.implementation;


import com.university.studentinfo.controller.definitions.StudentInfo;
import com.university.studentinfo.dto.Request.RequestStudentInfo;
import com.university.studentinfo.dto.Respons.ResponsStudentInfo;
import com.university.studentinfo.services.definition.StudentServiceDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

@RestController
public class StudentInfoController implements StudentInfo {

    private final StudentServiceDefinition studentServiceDefinitionl;

    public StudentInfoController(StudentServiceDefinition studentServiceDefinitionl) {
        this.studentServiceDefinitionl = studentServiceDefinitionl;
    }


    @Override
    public List<ResponsStudentInfo> getAllStudent() {

        return studentServiceDefinitionl.getAllStudent();
    }

    @Override
    public void create(RequestStudentInfo requestStudentInfo) {

        studentServiceDefinitionl.saveStudent(requestStudentInfo);
    }

    @Override
    public ResponseEntity<String> updateStudent(String id, RequestStudentInfo requestStudentInfo) {

        studentServiceDefinitionl.updateStudentInfo(id, requestStudentInfo);
        return ResponseEntity.ok("Student information updated");
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteStudent(String id) {
        return null;
    }
}
