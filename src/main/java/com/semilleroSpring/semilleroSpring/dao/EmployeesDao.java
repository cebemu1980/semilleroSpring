package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;

import java.util.List;

public interface EmployeesDao {
    List<EmployeesDTO> getAllEmployees();
}
