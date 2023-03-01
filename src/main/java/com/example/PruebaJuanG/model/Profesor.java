package com.example.PruebaJuanG.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "profesor")
public class Profesor {
    @Id
    private Long prof_id;
    private String nombre;
    private String direccion;
    private String telefono;

    private List<Curso> listCurso;
    private Depto depto;
}
