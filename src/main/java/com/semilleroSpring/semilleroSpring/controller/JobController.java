package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/job")
public class JobController {
    //Importamos la interfaz de los servicios
    @Autowired
    private JobService jobService;

    //para listar utilizamos el metodo get
    @GetMapping("/listJobs")//http://localhost:8081/job/listJobs
    public ResponseEntity<List<JobsDTO>> listarJobs(){
        List<JobsDTO> listJob = jobService.listarJobs();
        return ResponseEntity.ok(listJob);
    }

    //para consultar por id utilizamos el metodo get
    @GetMapping("/findById/{id}")//http://localhost:8081/job/findById/:id
    public JobsDTO findById(@PathVariable String id){
        return jobService.findById(id);
    }

    //para crear utilizamos el metodo post
    @PostMapping("/createJobs")//http://localhost:8081/job/createJobs
    public ResponseEntity<String> createJobs(@RequestBody JobsDTO jobsDTO){
        try{
            jobService.saveJob(jobsDTO);
            return new ResponseEntity<>("El cargo fue creado con exito", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //para actualizar utilizamos em metodo put
    @PutMapping("/updateJobs/{id}")//http://localhost:8081/job/updateJobs/:id
    public ResponseEntity<String> updateJobs(@RequestBody JobsDTO j, @PathVariable("id") String id){
        JobsDTO jobs = jobService.findById(id);
       if (jobs != null){
           jobs.setJob_id(id);
           jobs.setJob_title(j.getJob_title());
           jobs.setMin_salary(j.getMin_salary());
           jobs.setMax_salary(j.getMax_salary());
           jobService.updateJob(jobs);
           return new ResponseEntity<>("El cargo se actualizó con éxito",HttpStatus.OK);
       }else {
           return new ResponseEntity<>("No se puede encontrar el cargo con id"+id,HttpStatus.NOT_FOUND);
       }
    }

    //para eliminar utilizaremos el metodo delete
    @DeleteMapping("/deleteById/{id}")//http://localhost:8081/job/deleteById/:id
    public ResponseEntity<String> deleteById(@PathVariable String id){
        try{
            int dato = jobService.deleteByIdJob(id);
            if (dato == 0){
                return new ResponseEntity<>("No se puede encontrar el cargo con id="+id,HttpStatus.OK);
            }
            return new ResponseEntity<>("El cargo se eliminó con éxito",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se puede eliminar el cargo",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
