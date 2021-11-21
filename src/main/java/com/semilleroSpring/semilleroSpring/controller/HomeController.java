package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dao.JobsDaoImple;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.service.EmployeeService;
import com.semilleroSpring.semilleroSpring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hr")
public class HomeController {
    @Autowired
    private JobService jobService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String index(Model model){
        EmployeesDTO employeesDTO = new EmployeesDTO();
        List<EmployeesDTO> listarEmpleados = employeeService.getAllEmployees();
        List<JobsDTO> listaCargo = jobService.getAllJobs();

        model.addAttribute("titulo","Lista de empleados");
        model.addAttribute("empleadoDTO",listarEmpleados);
        model.addAttribute("empleados",listarEmpleados);
        model.addAttribute("cargos",listaCargo);
        return "home";
    }

    @GetMapping("/jobs")
    public String jobs(){ return "jobs"; }
}
