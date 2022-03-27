package com.ppconrado.bdjoseconrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppconrado.bdjoseconrado.domain.Categoria;
import com.ppconrado.bdjoseconrado.repositories.CategoriaRepository;
import com.ppconrado.bdjoseconrado.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
//		Declaracao de dependencia.	
//		Injecao de dependencia ou Inversao de Controle.
//	    Instancia automaticamente.
//		Buscar no BD dado um ID.
	
		@Autowired
		private CategoriaRepository repo;
	
		public Categoria buscar(Integer id) {
			Optional<Categoria> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
		
			}

