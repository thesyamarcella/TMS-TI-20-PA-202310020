package com.ibik.academicservices.academicservices.students;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class StudentsServices {
    @Autowired
    private StudentsRepo studentsRepo;

    //inserting into table
    public Students save(Students students){
        //query DTO
        return studentsRepo.save(students);
    }

    public Students findOne(int id){
        return studentsRepo.findById(id).get();
    }

    public Iterable<Students> findAll(){
        return studentsRepo.findAll();
    }

    public void removeOne(int id){
        studentsRepo.deleteById(id);
    }
}
