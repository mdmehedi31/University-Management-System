package com.university.studentinfo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbstudentinfo")
public class StudentEntity {


    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")

    private String firstName;
    @Column(name = "last_name")

    private String lastName;
    @Column(name = "email")

    private String email;
}
