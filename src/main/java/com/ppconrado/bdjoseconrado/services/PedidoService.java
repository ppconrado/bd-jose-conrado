package com.ppconrado.bdjoseconrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppconrado.bdjoseconrado.domain.Pedido;
import com.ppconrado.bdjoseconrado.repositories.PedidoRepository;
import com.ppconrado.bdjoseconrado.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
//		Declaracao de dependencia.	
//		Injecao de dependencia ou Inversao de Controle.
//	    Instancia automaticamente.
//		Buscar no BD dado um ID.
	
		@Autowired
		private PedidoRepository repo;
	
		public Pedido buscar(Integer id) {
			Optional<Pedido> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
		
			}

