package com.example.demo.controller;

import com.example.demo.entity.Libro;
import com.example.demo.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.guardar(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    
    @getMapping
    public ResponseEntity<List<Libro>> obtenerLibros() {
        List<Libro> libros = libroService.obtenerTodos();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}

