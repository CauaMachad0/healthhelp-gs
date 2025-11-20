package br.com.global.healthhelp.repository;

import br.com.global.healthhelp.model.Habito;
import br.com.global.healthhelp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitoRepository extends JpaRepository<Habito, Long> {

    List<Habito> findByUsuarioAndAtivoIsTrue(Usuario usuario);

}
