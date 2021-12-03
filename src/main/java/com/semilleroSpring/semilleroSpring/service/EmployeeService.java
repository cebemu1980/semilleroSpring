package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeesDTO> getEmployees();
    List<EmployeesDTO> getEmployeesPorCargo(String job_id);
    List<EmployeesDTO> getEmployeesPorDepartament(int department_id);
}
