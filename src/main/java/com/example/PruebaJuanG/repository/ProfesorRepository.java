package com.example.PruebaJuanG.repository;

import com.example.PruebaJuanG.model.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfesorRepository extends MongoRepository<Profesor,Long> {
}
