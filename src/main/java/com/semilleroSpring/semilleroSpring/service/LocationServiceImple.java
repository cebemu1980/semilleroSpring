package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.LocationDao;
import com.semilleroSpring.semilleroSpring.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class LocationServiceImple implements LocationService{
    @Autowired
    public LocationDao locationDao;

    @Override
    public List<LocationDTO> listLo() {
        return locationDao.listLo();
    }

    @Override
    public LocationDTO listId(int id) {
        return locationDao.listId(id);
    }

    @Override
    public int createOrUpdate(LocationDTO id) {
        int datos = locationDao.exist(id.getLocation_id());
        int exitoso = 0;
        if (datos > 0){
            exitoso = locationDao.update(id);
        }else {
            exitoso = locationDao.save(id);
        }
        return exitoso;
    }

    @Override
    public int save(LocationDTO id) {
        return locationDao.save(id);
    }

    @Override
    public int update(LocationDTO id) {
        return locationDao.update(id);
    }

    @Override
    public int delete(int id) {
        return locationDao.delete(id);
    }

}
