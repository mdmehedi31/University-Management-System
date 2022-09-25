package com.university.studentinfo.dto.Request;

import lombok.Data;

@Data
public class RequestStudentInfo {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
