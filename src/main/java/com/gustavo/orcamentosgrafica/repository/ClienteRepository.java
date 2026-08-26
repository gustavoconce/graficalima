package com.gustavo.orcamentosgrafica.repository;

import com.gustavo.orcamentosgrafica.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
