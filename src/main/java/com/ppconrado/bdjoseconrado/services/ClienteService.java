package com.ppconrado.bdjoseconrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppconrado.bdjoseconrado.domain.Cliente;
import com.ppconrado.bdjoseconrado.repositories.ClienteRepository;
import com.ppconrado.bdjoseconrado.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
//		Declaracao de dependencia.	
//		Injecao de dependencia ou Inversao de Controle.
//	    Instancia automaticamente.
//		Buscar no BD dado um ID.
	
		@Autowired
		private ClienteRepository repo;
	
		public Cliente buscar(Integer id) {
			Optional<Cliente> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
		
			}

