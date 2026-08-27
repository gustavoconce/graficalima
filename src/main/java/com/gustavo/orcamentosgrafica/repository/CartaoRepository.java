package com.gustavo.orcamentosgrafica.repository;

import com.gustavo.orcamentosgrafica.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository <Cartao, Long> {

    List<Cartao> findByMaterialAndGramaturaAndImpressao(
            String material,
            Integer gramatura,
            String impressao
    );

}

