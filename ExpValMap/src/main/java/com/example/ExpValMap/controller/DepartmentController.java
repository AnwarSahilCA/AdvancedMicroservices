package com.example.ExpValMap.controller;

import com.example.ExpValMap.Entity.Department;
import com.example.ExpValMap.repository.Deptrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private Deptrepo drepo;
    @PostMapping("/d")
    public ResponseEntity<Department>postd(@RequestBody Department department){
        drepo.save(department);
        return ResponseEntity.ok().body(department);
    }

}
