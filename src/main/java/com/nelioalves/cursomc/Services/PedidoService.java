package com.nelioalves.cursomc.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.Services.exceptions.ObjectNotFoundException;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
			if(obj == null) {
				throw new ObjectNotFoundException("Objeto não encontrado, ID: " + id + "Tipo: " + Pedido.class.getName());
			}
			return obj.orElse(null);
	}

}
