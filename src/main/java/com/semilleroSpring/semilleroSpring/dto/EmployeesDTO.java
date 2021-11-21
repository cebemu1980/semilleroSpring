package com.semilleroSpring.semilleroSpring.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeesDTO implements Serializable {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String hire_date;
    private JobsDTO jobs_ID;
    private BigDecimal salary;
    private BigDecimal commission_pct;
    private int manager_id;
    private DepartamentDTO departament_ID;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public JobsDTO getJobs_ID() {
        return jobs_ID;
    }

    public void setJobs_ID(JobsDTO jobs_ID) {
        this.jobs_ID = jobs_ID;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(BigDecimal commission_pct) {
        this.commission_pct = commission_pct;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public DepartamentDTO getDepartament_ID() {
        return departament_ID;
    }

    public void setDepartament_ID(DepartamentDTO departament_ID) {
        this.departament_ID = departament_ID;
    }

    @Override
    public String toString() {
        return "EmployeesDTO{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", hire_date='" + hire_date + '\'' +
                ", jobs_ID=" + jobs_ID +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                ", manager_id=" + manager_id +
                ", departament_ID=" + departament_ID +
                '}';
    }
}
