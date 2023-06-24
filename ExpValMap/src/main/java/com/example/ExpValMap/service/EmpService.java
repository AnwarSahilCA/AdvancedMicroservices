package com.example.ExpValMap.service;

import com.example.ExpValMap.Entity.Employee;
import com.example.ExpValMap.dto.Employeereq;
import com.example.ExpValMap.repository.Emprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    private Emprepo repo;

    public ResponseEntity<Employee> addElement(Employeereq employeereq) {
        Employee employee = new Employee(0, employeereq.getName(), employeereq.getEmail(), employeereq.getPno());
        repo.save(employee);
        return ResponseEntity.ok().body(employee);
    }
}