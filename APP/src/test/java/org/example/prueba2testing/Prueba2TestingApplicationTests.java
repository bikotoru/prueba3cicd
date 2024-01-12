package org.example.prueba2testing;

import org.example.prueba2testing.Model.Persona;
import org.example.prueba2testing.Service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Prueba2TestingApplicationTests {
    @Autowired
    private AuthenticationService authenticationService;

    @Test
    void contextLoads() {
    }
    @Test
    public void testSomeMethod() {
        Persona persona = authenticationService.validarCredenciales("carlosdiaz", "carlos123") ;
        assertEquals("Carlos", persona.getNombre());
    }
}
