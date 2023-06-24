package com.example.ExpValMap.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String pno;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee(int i, String name, String email, String pno) {
    }
}
