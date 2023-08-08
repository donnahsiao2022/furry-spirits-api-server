package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "account")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

}
