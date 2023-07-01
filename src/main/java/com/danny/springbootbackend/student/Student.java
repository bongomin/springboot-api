package com.danny.springbootbackend.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName="student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"

    )

    private Long id;
    private String firstName;
    private String secondName;
    private LocalDate dob;
    @Transient
    private Integer age;
    private String email;

    public Student() {
    }

//    Note: I removed the age field from the constructors such that its noyt saved to the db. the calculation is done from the getters
    public Student(Long id,
                   String firstName,
                   String secondName,
                   LocalDate dob,
                   String email) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dob = dob;
        this.email = email;
    }

    public Student(String firstName, String secondName, LocalDate dob, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

// Manuplate age without saving in the db
    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
