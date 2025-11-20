package br.com.global.healthhelp.controller;

import br.com.global.healthhelp.dto.RecomendacaoDTO;
import br.com.global.healthhelp.model.Usuario;
import br.com.global.healthhelp.service.RecomendacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/recomendacoes")
public class RecomendacaoWebController {

    private final RecomendacaoService recomendacaoService;

    public RecomendacaoWebController(RecomendacaoService recomendacaoService) {
        this.recomendacaoService = recomendacaoService;
    }

    private Usuario getUsuarioFake() {
        Usuario u = new Usuario();
        u.setId(1L);
        return u;
    }

    @GetMapping
    public String gerar(Model model) {
        Usuario usuario = getUsuarioFake();
        RecomendacaoDTO dto = recomendacaoService.gerarRecomendacao(usuario);
        model.addAttribute("recomendacao", dto);
        return "recomendacoes/detalhe";
    }
}
