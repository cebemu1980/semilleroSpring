package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.RegionDao;
import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.dto.RegionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RegionServiceImple implements RegionService{
    @Autowired
    public RegionDao regionDao;

    @Override
    public List<RegionDTO> listRegion() {
        return regionDao.listRegion();
    }

    @Override
    public int findById(int id) {
        return regionDao.findById(id);
    }

    @Override
    public int saveRegion(RegionDTO regionDTO) {
        return regionDao.saveRegion(regionDTO);
    }

    @Override
    public int updateRegion(RegionDTO regionDTO) {
        return regionDao.updateRegion(regionDTO);
    }

    @Override
    public int createOrUpdate(RegionDTO regionDTO) {
        int datos = regionDao.exist(regionDTO.getRegion_id());
        int exitoso = 0;
        if (datos > 0){
            exitoso = regionDao.updateRegion(regionDTO);
        }else {
            exitoso = regionDao.saveRegion(regionDTO);
        }
        return exitoso;
    }


    @Override
    public int deleteRegion(int id) {
        return regionDao.deleteRegion(id);
    }
}
