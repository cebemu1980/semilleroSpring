package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    public List<LocationDTO> listLo();
    public LocationDTO listId(int id);
    public int createOrUpdate(LocationDTO id);
    public int save(LocationDTO id);
    public int update(LocationDTO id);
    public int delete(int id);
}
