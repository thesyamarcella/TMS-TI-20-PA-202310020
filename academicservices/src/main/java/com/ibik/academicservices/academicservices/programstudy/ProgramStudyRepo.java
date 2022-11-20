package com.ibik.academicservices.academicservices.programstudy;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.;


//Remove @RepositoryRestResource below to disable auto REST api:
// @RepositoryRestResource
// public interface repositoryName extends CrudRepository<entityName, entityIdType>{}

public interface ProgramStudyRepo extends CrudRepository<ProgramStudy, Integer> {
    //function query JPAQL atau MYSQL Query
}
