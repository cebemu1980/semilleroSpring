package com.semilleroSpring.semilleroSpring.controller;

import com.semilleroSpring.semilleroSpring.dto.RegionDTO;
import com.semilleroSpring.semilleroSpring.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    public RegionService regionService;

    @GetMapping("/listRegion")//http://localhost:8081/region/listRegion
    public ResponseEntity<List<RegionDTO>> listRegion(){
        List<RegionDTO> listRe = regionService.listRegion();
        return ResponseEntity.ok(listRe);
    }
    @PostMapping("/findByIdRegion")//http://localhost:8081/region/findByIdRegion
    public ResponseEntity<String> findByIdRegion( @RequestBody RegionDTO regionDTO){
        regionService.findById(regionDTO.getRegion_id());
        return new ResponseEntity("Consulta por id",HttpStatus.OK);
    }
    @PostMapping("/saveRegion")//http://localhost:8081/region/saveRegion
    public ResponseEntity<String> saveRegion(@RequestBody RegionDTO regionDTO){
        try {
            regionService.saveRegion(regionDTO);
            return new ResponseEntity(null,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createOrUpdate")//http://localhost:8081/region/createOrUpdate
    public ResponseEntity<Object> createOrUpdate(@RequestBody RegionDTO regionDTO){
        regionService.createOrUpdate(regionDTO);
        return  new ResponseEntity(regionDTO,HttpStatus.OK);
    }
    @PostMapping("/deleteRegion")//http://localhost:8081/region/deleteRegion
    public ResponseEntity<Object> deleteRegion(@RequestBody RegionDTO regionDTO){
        regionService.deleteRegion(regionDTO.getRegion_id());
        return new ResponseEntity("eliminando la region",HttpStatus.OK);
    }
}
