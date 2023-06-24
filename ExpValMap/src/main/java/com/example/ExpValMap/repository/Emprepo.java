package com.example.ExpValMap.repository;

import com.example.ExpValMap.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Emprepo extends JpaRepository<Employee,Integer> {
}
