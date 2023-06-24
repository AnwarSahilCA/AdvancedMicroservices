package com.example.ExpValMap.controller;

import com.example.ExpValMap.Entity.Employee;
import com.example.ExpValMap.dto.Employeereq;
import com.example.ExpValMap.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/emp")

public class EmployeeController {
    @Autowired
    private EmpService empService;
    @PostMapping("/P")
    public ResponseEntity<Employee>post(@RequestBody @Valid Employeereq employeereq){
        return empService.addElement(employeereq);
    }
}
