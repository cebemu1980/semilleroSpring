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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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

    //Aquí se generaran las consultas del los select

    @RequestMapping("/listJobs")//http://localhost:8080/employee/listJobs
    public String listJobs(Model model){
        List<JobsDTO> listJobs = jobService.listarJobs();
        model.addAttribute("cargos",listJobs);
        List<EmployeesDTO> listEmployee = employeeService.getEmployees();
        model.addAttribute("employees",listEmployee);
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

    //Aquí se generaran las consultas del las tablas
    @RequestMapping("/empleadosXcargo/{id}")//http://localhost:8080/employee/empleadosXcargo/:id
    public String EmpleadosXcargo(Model model, @PathVariable String id){
        List<EmployeesDTO> allEmpXcarg = employeeService.getEmployeesPorCargo(id);
        model.addAttribute("tablaEmpXcarg",allEmpXcarg);
        return "/views/table/employeexjobtable";
    }
    @RequestMapping("/empleadosXdepartament/{id}")//http://localhost:8080/employee/empleadosXdepartament/:id
    public String EmpleadosXdepartament(Model model, @PathVariable String id){
        List<EmployeesDTO> allEmpXdepar = employeeService.getEmployeesPorDepartament(id);
        model.addAttribute("tablaEmpXdepar",allEmpXdepar);
        return "/views/table/employeexdepartamentable";
    }
    @RequestMapping("/empleadosXmanager/{id}")//http://localhost:8080/employee/empleadosXmanager/:id
    public String EmpleadosXmanager(Model model, @PathVariable String id){
        List<EmployeesDTO> allEmpXman = employeeService.getEmployeesPorManager(id);
        model.addAttribute("tablaEmpXman",allEmpXman);
        return "/views/table/employeexmanagertable";
    }
    @RequestMapping("/empleadosXhistory/{id}")//http://localhost:8080/employee/empleadosXhistory/:id
    public String EmpleadosXhistory(Model model, @PathVariable String id){
        List<EmployeesDTO> allEmpXhist = employeeService.getEmployeesPorNombre(id);
        model.addAttribute("tablaEmpXhist",allEmpXhist);
        return "/views/table/employeexhistorytable";
    }
    @RequestMapping("/listEmployeeHistory")//http://localhost:8080/employee/listEmployeeHistory
    public String listEmployeeHistory(Model model){
        List<EmployeesDTO> listEmployee = employeeService.getEmployees();
        model.addAttribute("employees",listEmployee);
        return "/views/table/employeexhistorytable";
    }
    @RequestMapping("/empleadosXcity/{id}")//http://localhost:8080/employee/empleadosXcity/:id
    public String EmpleadosXcity(Model model, @PathVariable String id){
        List<EmployeesDTO> allEmpXcity = employeeService.getEmployeesPorCity(id);
        model.addAttribute("tablaEmpXcity",allEmpXcity);
        return "/views/table/employeexcitytable";
    }


}
