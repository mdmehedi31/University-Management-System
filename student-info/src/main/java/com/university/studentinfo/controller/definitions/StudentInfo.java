package com.university.studentinfo.controller.definitions;

import com.university.studentinfo.dto.Request.RequestStudentInfo;
import com.university.studentinfo.dto.Respons.ResponsStudentInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.spec.XPathType;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/v1/student")
public interface StudentInfo {

    @GetMapping("/")
    List<ResponsStudentInfo> getAllStudent();

    @PostMapping("/create")
    void create(@ModelAttribute RequestStudentInfo requestStudentInfo);

    @PutMapping("/{id}")
    ResponseEntity<String> updateStudent(@PathVariable String id, @ModelAttribute RequestStudentInfo requestStudentInfo);

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable String id);
}
