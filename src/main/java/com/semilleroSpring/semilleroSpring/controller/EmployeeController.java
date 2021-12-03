package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.DepartamentDTO;
import com.semilleroSpring.semilleroSpring.dto.EmployeesDTO;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.service.DepartamentService;
import com.semilleroSpring.semilleroSpring.service.EmployeeService;
import com.semilleroSpring.semilleroSpring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private JobService jobService;
    @Autowired
    private DepartamentService departamentService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/listJobs")//http://localhost:8080/employee/listJobs
    public String listJobs(Model model){
        List<JobsDTO> listJobs = jobService.listarJobs();
        model.addAttribute("cargos",listJobs);
        return "views/employeexjob";
    }
    @RequestMapping("/listEmployee")//http://localhost:8080/employee/listEmployee
    public String listEmployee(Model model){
        List<EmployeesDTO> listEmployee = employeeService.getEmployees();
        model.addAttribute("employees",listEmployee);
        return "views/employeexhistory";
    }
    @RequestMapping("/listEmployeeXcity")//http://localhost:8080/employee/listEmployeeXcity
    public String listEmployeeXcity(Model model){
        List<EmployeesDTO> listEmployeeXcity = employeeService.getEmployees();
        model.addAttribute("employeesxcity",listEmployeeXcity);
        return "views/employeexcity";
    }
    @RequestMapping("/listDepartament")//http://localhost:8080/employee/listDepartament
    public String listDepartament(Model model){
        List<DepartamentDTO> listDepartament = departamentService.listDepartament();
        model.addAttribute("departaments",listDepartament);
        return "views/employeexdepartament";
    }
    @RequestMapping("/listDepartamentXmanager")//http://localhost:8080/employee/listDepartamentXmanager
    public String listDepartamentXmanager(Model model){
        List<DepartamentDTO> listDepartamentXmanager = departamentService.listDepartament();
        model.addAttribute("departamentsxmanager",listDepartamentXmanager);
        return "views/employeexmanager";
    }


}
