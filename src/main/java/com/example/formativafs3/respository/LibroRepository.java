package com.example.formativafs3.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.formativafs3.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}

