package com.example.formativafs3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.formativafs3.model.Libro;
import com.example.formativafs3.respository.*;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibro(Long id) {
        return libroRepository.findById(id);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public Optional<Libro> actualizarLibro(Long id, Libro libroDetalles) {
        return libroRepository.findById(id).map(libroExistente -> {
            libroExistente.setTitulo(libroDetalles.getTitulo());
            libroExistente.setAutor(libroDetalles.getAutor());
            libroExistente.setGenero(libroDetalles.getGenero());
            libroExistente.setAnioPublicacion(libroDetalles.getAnioPublicacion());
            return libroRepository.save(libroExistente); 
        });
    }
}


