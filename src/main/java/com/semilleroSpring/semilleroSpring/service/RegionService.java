package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dto.JobsDTO;
import com.semilleroSpring.semilleroSpring.dto.RegionDTO;

import java.util.List;

public interface RegionService {
    public List<RegionDTO> listRegion();
    public int findById(int id);
    public int saveRegion(RegionDTO regionDTO);
    public int updateRegion(RegionDTO regionDTO);
    public int createOrUpdate(RegionDTO regionDTO);
    public int deleteRegion(int id);
}
