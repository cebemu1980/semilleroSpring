package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeesDTO> getAllEmployees();
}
