package org.example.prueba2testing.Repository;

import org.example.prueba2testing.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByUsernameAndPassword(String username, String password);

}