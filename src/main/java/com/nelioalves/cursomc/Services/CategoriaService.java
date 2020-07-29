package com.nelioalves.cursomc.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.Services.exceptions.ObjectNotFoundException;
import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	
	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj.orElse(null);
	}
	

}
