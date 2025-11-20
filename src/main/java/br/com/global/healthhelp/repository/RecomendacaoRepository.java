package br.com.global.healthhelp.repository;

import br.com.global.healthhelp.model.Recomendacao;
import br.com.global.healthhelp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Long> {

    List<Recomendacao> findTop5ByUsuarioOrderByCriadaEmDesc(Usuario usuario);

}
