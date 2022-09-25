package com.university.studentinfo.repository;

import com.university.studentinfo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
/*@EnableJpaRepositories*/
public interface StudentInfoRepository extends JpaRepository<StudentEntity, Long> {
}
