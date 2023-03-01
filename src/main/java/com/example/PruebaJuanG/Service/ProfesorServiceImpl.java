package com.example.PruebaJuanG.Service;

import com.example.PruebaJuanG.model.Profesor;
import com.example.PruebaJuanG.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service

public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long> implements ProfesorService{

    @Autowired
    ProfesorRepository profesorRepository;
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return profesorRepository;
    }
}
