package org.example.prueba2testing;
import org.example.prueba2testing.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    AuthenticationService authenticationService;
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        var persona = authenticationService.validarCredenciales(username, password);

        if (persona == null) {
            model.addAttribute("error", "Credenciales inválidas. Inténtelo nuevamente.");
            return "login";
        } else {
            model.addAttribute("persona", persona);
            return "home";
        }
    }


}
