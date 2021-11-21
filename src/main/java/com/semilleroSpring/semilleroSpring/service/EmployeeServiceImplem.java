package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.EmployeesDao;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@Service
public class EmployeeServiceImplem implements EmployeeService{
    @Autowired
    private EmployeesDao employeesDao;

    @Override
    public List<EmployeesDTO> getAllEmployees() {
        return employeesDao.getAllEmployees();
    }
}
