package com.xcode.SpringMysqlREST.Repository;

import com.xcode.SpringMysqlREST.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
