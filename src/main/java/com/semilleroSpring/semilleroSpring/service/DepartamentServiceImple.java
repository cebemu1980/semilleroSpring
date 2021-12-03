package com.semilleroSpring.semilleroSpring.service;

import com.semilleroSpring.semilleroSpring.dao.DepartamentDao;
import com.semilleroSpring.semilleroSpring.dto.DepartamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DepartamentServiceImple implements DepartamentService{
    @Autowired
    public DepartamentDao departamentDao;

    @Override
    public List<DepartamentDTO> listDepartament() {
        return departamentDao.listDepartament();
    }
}
