package br.com.global.healthhelp.repository;

import br.com.global.healthhelp.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}
