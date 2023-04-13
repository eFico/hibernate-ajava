package org.alfa.comex.data.daos;

import org.alfa.comex.data.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
