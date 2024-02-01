package com.employeewebapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // to map class with table in database
public class Employee {
    @Id // to show primary key of entity(table)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_num")
    private long phoneNum;
    private String email;
    private String address;
    private String gender;



}
