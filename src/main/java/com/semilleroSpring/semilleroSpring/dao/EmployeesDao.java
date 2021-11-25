package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeesDao {
    List<EmployeesDTO> getEmployeesPorCargo(String job_id);
}
