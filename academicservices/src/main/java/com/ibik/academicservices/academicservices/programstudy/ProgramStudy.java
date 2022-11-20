package com.ibik.academicservices.academicservices.programstudy;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.ibik.academicservices.academicservices.programs.Programs;


@Entity
@Table(name="programstudy")

public class ProgramStudy implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(length = 20)
    private String description;

    @Column(length = 5)
    @NotEmpty(message = "Code is required")
    private String code;

    //before
    // @Column(length = 11)
    // @Min (value = 1,message = "Program is Required")
    // private int program_id;

    //after
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs programs;

    //before
    // @Column(length = 11)
    // @Min (value = 1,message = "Faculty is Required")
    // private int faculty_id;

    //after
    @OneToMany
    @JoinColumn
    private Set<ProgramStudy> Faculty;

    @Column(length = 11)
    @Min (value = 1,message = "Program is Required")
    private int department_id;

    @Column(nullable = false, columnDefinition =  "TINYINT(1)")
    private boolean is_active;









    public ProgramStudy(int id, @NotEmpty(message = "Name is required") String name, String description,
            @NotEmpty(message = "Code is required") String code, Programs programs, Set<ProgramStudy> faculty,
            @Min(value = 1, message = "Program is Required") int department_id, boolean is_active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.programs = programs;
        Faculty = faculty;
        this.department_id = department_id;
        this.is_active = is_active;
    }



    public ProgramStudy(){
    }

    

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        this.programs = programs;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Set<ProgramStudy> getFaculty() {
        return Faculty;
    }

    public void setFaculty(Set<ProgramStudy> faculty) {
        Faculty = faculty;
    }

}
