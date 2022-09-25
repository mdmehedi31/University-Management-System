package com.university.studentinfo.services.implementation;

import com.university.studentinfo.dto.Request.RequestStudentInfo;
import com.university.studentinfo.dto.Respons.ResponsStudentInfo;
import com.university.studentinfo.entity.StudentEntity;
import com.university.studentinfo.exception.NotFoundException;
import com.university.studentinfo.repository.StudentInfoRepository;
import com.university.studentinfo.services.definition.StudentServiceDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServicesImple implements StudentServiceDefinition {

    private final StudentInfoRepository studentInfoRepository;

    public StudentServicesImple(StudentInfoRepository studentInfoRepository) {
        this.studentInfoRepository = studentInfoRepository;
    }

    @Override
    public List<ResponsStudentInfo> getAllStudent() {
        List<ResponsStudentInfo> studentInfoList = new ArrayList<>();
        List<StudentEntity> studentList = studentInfoRepository.findAll();
        for (StudentEntity studentEntity : studentList) {

            var responsStudent = entityTodto(studentEntity);
            studentInfoList.add(responsStudent);
        }
        return studentInfoList;
    }

    @Override
    public void saveStudent(RequestStudentInfo requestStudentInfo) {

        studentInfoRepository.save(dtoToentity(requestStudentInfo));
    }

    @Override
    public void updateStudentInfo(String id, RequestStudentInfo requestStudentInfo) {

        StudentEntity studentEntity = studentInfoRepository.findById(Long.parseLong(id)).
                orElseThrow(() -> new NotFoundException(id));

        StudentEntity studentUpdate = dtoToentity(requestStudentInfo);
        studentUpdate.setId(studentEntity.getId());
        studentInfoRepository.save(studentUpdate);
    }

    @Override
    public ResponsStudentInfo entityTodto(StudentEntity studentEntity) {

        var responsStudentInfo = new ResponsStudentInfo();
        BeanUtils.copyProperties(studentEntity, responsStudentInfo);

        var name = studentEntity.getFirstName() + " " + studentEntity.getLastName();

        responsStudentInfo.setName(name);
        responsStudentInfo.setEmail(studentEntity.getEmail());

        return responsStudentInfo;
    }

    @Override
    public StudentEntity dtoToentity(RequestStudentInfo requestStudentInfo) {

        var studentEntity = new StudentEntity();
        BeanUtils.copyProperties(requestStudentInfo, studentEntity);

        studentEntity.setFirstName(requestStudentInfo.getFirstName());
        studentEntity.setLastName(requestStudentInfo.getLastName());
        studentEntity.setEmail(requestStudentInfo.getEmail());

        return studentEntity;
    }
}
