package com.example.PruebaJuanG.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "depto")
public class Depto {
    private String depto_id;
    private String nombre;
    private String director;
    private String descripcion;
}
