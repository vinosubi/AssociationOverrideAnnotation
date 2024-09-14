package com.example.officeemployee.controller;

import com.example.officeemployee.model.OfficeEmployee;
import com.example.officeemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/create")
    public String createEmployee() {
        employeeService.createEmployees();
        return "Employee created!";
    }

    @GetMapping("/officeEmployee")
    public OfficeEmployee getOfficeEmployee() {
        return employeeService.getOfficeEmployee(1L);
    }
}
