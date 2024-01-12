package org.example.prueba2testing.Service;

import org.example.prueba2testing.Model.Persona;
import org.example.prueba2testing.Model.Usuario;
import org.example.prueba2testing.Repository.PersonaRepository;
import org.example.prueba2testing.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    public AuthenticationService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    public Persona validarCredenciales(String username, String password) {
        Usuario User = usuarioRepository.findByUsernameAndPassword(username, password);
        if (User != null) {
            var persona = personaRepository.findByRut(User.getRut());
            return persona;
        }

        return null;
    }

}