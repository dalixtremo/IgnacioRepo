package com.mini.challenge.business.service;

import com.mini.challenge.business.domain.EmployeeService;
import com.mini.challenge.data.entity.Employee;
import com.mini.challenge.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employees =
                employeeRepository.findAll()
                .stream()
                .filter(employee ->
                        employee
                                .getFirstName()
                                        .toLowerCase().startsWith(name.toLowerCase()
                                        .substring(0,3)))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public List<Employee> searchByDOB(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dob, formatter);

        return employeeRepository.findAll()
                        .stream()
                        .filter(employee ->
                                employee.getDob().isEqual(date))
                        .collect(Collectors.toList());
    }
    @Override
    public List<Employee> searchByEmail(String email) {
        return employeeRepository.findByEmailAccount(email);
    }

    @Override
    public List<Employee> searchByObject(Employee employee) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> e.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase()))
                .filter(e -> e.getDob().isEqual(employee.getDob()))
                .filter(e -> e.getEmailAddress().toLowerCase().contains(employee.getEmailAddress().toLowerCase()))
                .collect(Collectors.toList());
    }
}
