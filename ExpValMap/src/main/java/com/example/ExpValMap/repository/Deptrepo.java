package com.example.ExpValMap.repository;

import com.example.ExpValMap.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Deptrepo extends JpaRepository<Department,Integer> {
}
