package com.semilleroSpring.semilleroSpring.dto;

import java.io.Serializable;

public class DepartamentDTO implements Serializable {
    private int department_id;
    private String department_name;
    private int manager_id;
    private LocationDTO location_ID;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public LocationDTO getLocation_ID() {
        return location_ID;
    }

    public void setLocation_ID(LocationDTO location_ID) {
        this.location_ID = location_ID;
    }

    @Override
    public String toString() {
        return "DepartamentDTO{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", manager_id=" + manager_id +
                ", location_ID=" + location_ID +
                '}';
    }
}
