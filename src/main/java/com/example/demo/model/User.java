package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }
}

// package com.example.demo.model;

// public class User {
// private String name;
// private int age;
// private int id;

// public String getName() {
// return name;
// }
// public void setName(String name) {
// this.name = name;
// }

// public int getAge() {
// return age;
// }
// public void setAge(int age) {
// this.age = age;
// }

// public int getId() {
// return id;
// }
// public void setId(int id) {
// this.id = id;
// }
// }
