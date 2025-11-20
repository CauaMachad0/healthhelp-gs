package br.com.global.healthhelp.controller;

import br.com.global.healthhelp.dto.AtividadeDTO;
import br.com.global.healthhelp.dto.RegistroDiarioDTO;
import br.com.global.healthhelp.model.CategoriaAtividade;
import br.com.global.healthhelp.model.Usuario;
import br.com.global.healthhelp.repository.CategoriaAtividadeRepository;
import br.com.global.healthhelp.service.RegistroDiarioService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/web/registros")
public class RegistroDiarioWebController {

    private final RegistroDiarioService registroService;
    private final CategoriaAtividadeRepository categoriaRepo;

    public RegistroDiarioWebController(RegistroDiarioService registroService,
                                       CategoriaAtividadeRepository categoriaRepo) {
        this.registroService = registroService;
        this.categoriaRepo = categoriaRepo;
    }

    private Usuario getUsuarioFake() {
        Usuario u = new Usuario();
        u.setId(1L);
        return u;
    }

    @GetMapping
    public String listar(@PageableDefault(size = 10) Pageable pageable, Model model) {
        var usuario = getUsuarioFake();
        var pagina = registroService.listarPorUsuario(usuario, pageable);
        model.addAttribute("pagina", pagina);
        return "registros/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("dataHoje", LocalDate.now());
        List<CategoriaAtividade> categorias = categoriaRepo.findAll();
        model.addAttribute("categorias", categorias);
        return "registros/form";
    }

    @PostMapping
    public String salvar(@RequestParam("dataRegistro") LocalDate dataRegistro,
                         @RequestParam(value = "pontuacaoEquilibrio", required = false) Integer pontuacaoEquilibrio,
                         @RequestParam(value = "observacoes", required = false) String observacoes,
                         @RequestParam("idCategoria") Long idCategoria,
                         @RequestParam("inicio") String inicio,
                         @RequestParam("fim") String fim) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime inicioDt = LocalDateTime.parse(inicio, formatter);
        LocalDateTime fimDt = LocalDateTime.parse(fim, formatter);

        AtividadeDTO atividade = new AtividadeDTO(null, idCategoria, inicioDt, fimDt, null);
        RegistroDiarioDTO dto = new RegistroDiarioDTO(null, dataRegistro, pontuacaoEquilibrio, observacoes, List.of(atividade));

        Usuario usuario = getUsuarioFake();
        registroService.salvarRegistro(usuario, dto);

        return "redirect:/web/registros";
    }
}
