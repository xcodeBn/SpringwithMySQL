package com.xcode.SpringMysqlREST.Controller;

import com.xcode.SpringMysqlREST.Repository.EmployeeRepository;
import com.xcode.SpringMysqlREST.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    //get all employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // Create a new employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();

            String response = "Success:" + Boolean.toString(true);
            String devider = "\n";
            // Update the employee's information if new values are provided
            if (updatedEmployee.getFirstName() != null) {
                existingEmployee.setFirstName(updatedEmployee.getFirstName());
                response += devider+ "FirstName set to:" + updatedEmployee.getFirstName();
            }
            if (updatedEmployee.getLastName() != null) {
                existingEmployee.setLastName(updatedEmployee.getLastName());
                response += devider+ "LastName set to:" + updatedEmployee.getLastName();

            }
            if (updatedEmployee.getEmailId() != null) {
                existingEmployee.setEmailId(updatedEmployee.getEmailId());
                response += devider+ "EmailId set to:" + updatedEmployee.getEmailId();

            }
            // Update other fields as needed

            employeeRepository.save(existingEmployee); // Save the updated employee

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }






}
