package com.xcode.SpringMysqlREST.Controller;


import com.xcode.SpringMysqlREST.Repository.DepartmentRepository;
import com.xcode.SpringMysqlREST.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {


    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable long id){
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
       if(optionalDepartment.isPresent()){
           Department department = optionalDepartment.get();
           return ResponseEntity.ok(department);
       }
       else {
           return ResponseEntity.notFound().build();
       }
    }



}
