package com.ppconrado.bdjoseconrado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppconrado.bdjoseconrado.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}

//Nao precisa criar repository nas subclasses - vem por heranca