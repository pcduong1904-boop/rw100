package com.vti.entity;


import jakarta.persistence.*;
import lombok.*;

@ToString
@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id// dai dien cho khoa chinh
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="department_id")// truong nay cho biet la thuoc tinh nay map voi cot department_id trong db
    private Integer id;
    @Column(name="department_name", nullable = false, unique = true, length = 100)
    private String name;


}
