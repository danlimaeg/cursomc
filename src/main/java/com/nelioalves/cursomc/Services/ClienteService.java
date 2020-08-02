package com.nelioalves.cursomc.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.Services.exceptions.ObjectNotFoundException;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository repo;
	
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj.orElse(null);
	}
	

}
