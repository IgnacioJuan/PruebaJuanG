package com.example.PruebaJuanG.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "curso")
public class Curso {
    private String curso_id;
    private String nombre;
    private String nivel;
    private String descripcion;
}
