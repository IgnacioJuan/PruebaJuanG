package com.example.PruebaJuanG.controller;


import com.example.PruebaJuanG.Service.ProfesorService;
import com.example.PruebaJuanG.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProfesors() {
        return new ResponseEntity<>(profesorService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesor(
            @RequestBody Profesor p) {
        return new ResponseEntity<>(profesorService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor p) {
        Profesor profesorENcontrada = profesorService.findById(id);
        if (profesorENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                profesorENcontrada.setNombre(p.getNombre());
                profesorENcontrada.setDireccion(p.getDireccion());
                profesorENcontrada.setTelefono(p.getTelefono());
                profesorENcontrada.setDepto(p.getDepto());
                profesorENcontrada.setListCurso(p.getListCurso());
                return new ResponseEntity<>(profesorService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
