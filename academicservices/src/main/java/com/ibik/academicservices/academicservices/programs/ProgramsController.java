package com.ibik.academicservices.academicservices.programs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ProgressMonitor;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibik.academicservices.academicservices.dto.ResponseData;

@RestController
@RequestMapping("/api/programs") //contain endpoint

public class ProgramsController {
    @Autowired
    private ProgramsServices programsServices;

    // @GetMapping //
    // public String HelloWorld(){
    //     return "<h1>Hello</h1>";
    // }

    @PostMapping()
    public ResponseEntity<ResponseData<Programs>> postPrograms(@Valid @RequestBody Programs programs, Errors errors){
        ResponseData<Programs> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Programs> value = new ArrayList<>();
        value.add(programsServices.save(programs));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
        // return programsServices.save(programs);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Programs>> fetchPrograms(){
        ResponseData<Programs> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<Programs> value = (List<Programs>) programsServices.findAll();
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        // return programsServices.findAll();
    }

    @GetMapping("/{id}") //menambahkan parameter untuk mencari berdasarkan id
    public ResponseEntity<ResponseData<Programs>> fetchProgramsById(@PathVariable("id") int id){
        ResponseData<Programs> responseData = new ResponseData<>();
        try {
            responseData.setResult(true);
            List<Programs> value = new ArrayList<>();
            value.add(programsServices.findOne(id));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        // return programsServices.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Programs>> updatePrograms(@RequestBody Programs programs, Errors errors){
        ResponseData<Programs> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        try {
            responseData.setResult(true);
            List<Programs> value = new ArrayList<>();
            value.add(programsServices.update(programs));
            responseData.setData(value);

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.getMessage().add("ID is Required");
            responseData.setResult(false);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        //update query
        // return programsServices.save(programs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Void>> deleteProgramsById(@PathVariable("id") int id){
        ResponseData<Void> responseData = new ResponseData<>();
        try {
            programsServices.removeOne(id);
            responseData.setResult(true);
            responseData.getMessage().add("Successfully Remove");

            return ResponseEntity.ok(responseData);
        } catch (Exception ex) {
            responseData.setResult(false);
            responseData.getMessage().add(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        // programsServices.removeOne(id);
    }
    
}
