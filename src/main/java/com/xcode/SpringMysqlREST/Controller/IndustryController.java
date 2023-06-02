package com.xcode.SpringMysqlREST.Controller;

import com.xcode.SpringMysqlREST.Repository.IndustryRepository;
import com.xcode.SpringMysqlREST.model.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/")
public class IndustryController {

    @Autowired
    IndustryRepository industryRepository;

    @GetMapping("/industries")
    public List<Industry> getIndustries(){
        return industryRepository.findAll();
    }

    // Create a new industry
    @PostMapping("/industries")
    public Industry createIndustry(@RequestBody Industry industry) {
        return industryRepository.save(industry);
    }

    @GetMapping("/industries/{id}")
    public ResponseEntity<Industry> getEmployeeById(@PathVariable Long id) {

        Optional<Industry> optionalIndustry = industryRepository.findById(id);
        if (optionalIndustry.isPresent()) {
            Industry industry = optionalIndustry.get();
            return ResponseEntity.ok(industry);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/industries/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Optional<Industry> optionalIndustry = industryRepository.findById(id);
        if (optionalIndustry.isPresent()) {
            industryRepository.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/industries/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Industry updatedIndustry) {
        Optional<Industry> optionalEmployee = industryRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Industry existingIndustry = optionalEmployee.get();

            String response = "Success:" + Boolean.toString(true);
            String devider = "\n";
            // Update the employee's information if new values are provided
            if (updatedIndustry.getIndustryName() != null) {
                existingIndustry.setIndustryName(updatedIndustry.getIndustryName());
                response += devider+ "FirstName set to:" + updatedIndustry.getIndustryName();
            }

            // Update other fields as needed

            industryRepository.save(existingIndustry); // Save the updated employee

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
