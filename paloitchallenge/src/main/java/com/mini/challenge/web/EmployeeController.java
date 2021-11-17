package com.mini.challenge.web;

import com.mini.challenge.business.domain.EmployeeService;
import com.mini.challenge.data.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger("EmployeeController");
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/searchByName/{name}")
    public List<Employee> searchByName(@PathVariable String  name){
        return employeeService.searchByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchByDob/")
    public List<Employee> searchByDOB(@RequestParam String dob){
        return employeeService.searchByDOB(dob);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchByEmail/")
    public List<Employee> searchByEmail(@RequestParam String email){
        return employeeService.searchByEmail(email);
    }

    @PostMapping("/searchByObject")
    public List<Employee> searchByObject(@RequestBody Employee employee) throws ParseException {
        return employeeService.searchByObject(employee);
    }

}
