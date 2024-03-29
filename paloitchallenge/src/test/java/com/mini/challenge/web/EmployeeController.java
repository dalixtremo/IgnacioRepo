package com.mini.challenge.web;

import com.mini.challenge.business.domain.EmployeeService;
import com.mini.challenge.data.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeController.class)
public class EmployeeController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService mockedService;




}
