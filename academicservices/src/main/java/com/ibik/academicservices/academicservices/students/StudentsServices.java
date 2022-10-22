package com.ibik.academicservices.academicservices.students;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentsServices {
    
    @Autowired
    private StudentsRepo studentsRepo;

    public Students save(Students students){
        return studentsRepo.save(students);
    }

    public Students update(Students students) {
        Students result = findOne(students.getId());

        result.setFirstname(students.getFirstname());
        result.setMiddlename(students.getMiddlename());
        result.setLastname(students.getLastname());
        result.setNpm(students.getNpm());
        result.setProgram_id(students.getProgram_id());
        result.setDepartment_id(students.getDepartment_id());

        return result;
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
