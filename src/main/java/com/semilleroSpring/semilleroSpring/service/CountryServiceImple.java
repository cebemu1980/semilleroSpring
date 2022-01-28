package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.CountryDao;
import com.semilleroSpring.semilleroSpring.dto.CountriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CountryServiceImple implements CountryService{
    @Autowired
    public CountryDao countryDao;


    @Override
    public int save(CountriesDTO id) {
        return countryDao.save(id);
    }

    @Override
    public int update(CountriesDTO id) {
        return countryDao.update(id);
    }

    @Override
    public int delete(String id) {
        return countryDao.delete(id);
    }

    @Override
    public int createOrUpdate(CountriesDTO id) {
        System.out.println("entro al servicio de createOrUpdate"+id);
        int cuantos = countryDao.exist(id.getCountry_id());
        int exitoso=0;
        if (cuantos >0) {
            exitoso=countryDao.update(id);

        }else{
            exitoso=countryDao.save(id);
        }
        return exitoso;
    }

    @Override
    public List<CountriesDTO> list() {
        return countryDao.list();
    }
}
