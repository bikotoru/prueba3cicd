package org.example.prueba2testing.Repository;

import org.example.prueba2testing.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    Persona findByRut(String rut);
}