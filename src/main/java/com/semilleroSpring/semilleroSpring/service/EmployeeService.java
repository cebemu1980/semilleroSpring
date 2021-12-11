package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeesDTO> getEmployees();
    List<EmployeesDTO> getEmployeesPorCargo(String job_id);
    List<EmployeesDTO> getEmployeesPorNombre(String last_name);
    List<EmployeesDTO> getEmployeesPorDepartament(String department_id);
    List<EmployeesDTO> getEmployeesPorManager(String manager_id);
    List<EmployeesDTO> getEmployeesPorCity(String first_name);
}
