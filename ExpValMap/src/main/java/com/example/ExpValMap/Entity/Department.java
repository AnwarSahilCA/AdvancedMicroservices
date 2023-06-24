package com.example.ExpValMap.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
@Id
@GeneratedValue
    private int id;
    private String dname;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee> employee=new ArrayList<>();
}
