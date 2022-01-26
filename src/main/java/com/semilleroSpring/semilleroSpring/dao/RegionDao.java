package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.RegionDTO;

import java.util.List;

public interface RegionDao {
    public List<RegionDTO>listRegion();
    public int findById(int id);
    public int exist(int id);
    public int saveRegion(RegionDTO regionDTO);
    public int updateRegion(RegionDTO regionDTO);
    public int deleteRegion(int id);
}
