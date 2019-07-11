package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class EmployeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;

    @Column(name = "emp_name")
    @NotNull
    private String ename;

    @Column(name = "sal")
    @NotNull
    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
