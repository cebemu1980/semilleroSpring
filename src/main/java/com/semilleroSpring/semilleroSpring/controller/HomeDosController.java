package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dao.DepartamentDao;
import com.semilleroSpring.semilleroSpring.dto.DepartamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/views")//http://localhost:8080/api
public class HomeDosController {
    @Autowired
    private DepartamentDao departamentDao;
    @RequestMapping("/listarDepartamento")
    public String listarDepartamento(Model model){
        //DepartamentDTO departamentDTO = new DepartamentDTO();
        List<DepartamentDTO> listaDepart = departamentDao.listDepartament();
        model.addAttribute("listaDepartam",listaDepart);
        //model.addAttribute("departamentDTO",departamentDTO);
        return "/views/homeDos";
    }
    @RequestMapping("/listEmployeeDos/{id}")
    public String listEmployeeDos(@PathVariable("id") String id, Model model){
        return "/views/homeDos";
    }
}
