package br.com.global.healthhelp.controller;

import br.com.global.healthhelp.model.Usuario;
import br.com.global.healthhelp.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepo;

    public UsuarioController(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/cadastro";
    }

    @PostMapping
    public String salvar(Usuario usuario) {
        usuarioRepo.save(usuario);
        return "redirect:/login?cadastrado";
    }
}
