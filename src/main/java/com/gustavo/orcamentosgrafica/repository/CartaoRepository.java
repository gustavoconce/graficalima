package com.gustavo.orcamentosgrafica.repository;

import com.gustavo.orcamentosgrafica.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository <Cartao, Long> {
}
