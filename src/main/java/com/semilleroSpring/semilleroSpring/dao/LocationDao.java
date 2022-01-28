package com.semilleroSpring.semilleroSpring.dao;

import com.semilleroSpring.semilleroSpring.dto.LocationDTO;

import java.util.List;

public interface LocationDao {
    public List<LocationDTO> listLo();
    public LocationDTO listId(int id);
    public int exist(int id);
    public int save(LocationDTO id);
    public int update(LocationDTO id);
    public int delete(int id);
}
