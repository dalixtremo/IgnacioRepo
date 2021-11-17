package com.mini.challenge.business.domain;

import com.mini.challenge.data.entity.Employee;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> searchByName(String name);
    List<Employee> searchByDOB(String dob);
    List<Employee> searchByEmail(String email);
    List<Employee> searchByObject(Employee employee);
}
