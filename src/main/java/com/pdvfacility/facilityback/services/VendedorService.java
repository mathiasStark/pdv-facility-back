package com.pdvfacility.facilityback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdvfacility.facilityback.entities.Vendedor;
import com.pdvfacility.facilityback.repositories.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repository;
	
	public Vendedor insert(Vendedor vendedor) {
		Vendedor entity = new Vendedor();
		entity.setNome(vendedor.getNome());
		entity.setCpf(vendedor.getCpf());
		entity.setLogin(vendedor.getLogin());
		entity.setSenha(vendedor.getSenha());
		return repository.save(entity);
	}

	public List<Vendedor> findAll() {
		return repository.findAll();
	}

	public Vendedor updateVendedor(Long id, Vendedor vendedor) {
		Optional<Vendedor> obj = repository.findById(id);
		Vendedor entity = obj.get();
		entity.setCpf(vendedor.getCpf());
		entity.setNome(vendedor.getNome());
		entity.setLogin(vendedor.getLogin());
		entity.setSenha(vendedor.getSenha());
		return repository.save(entity);
	}

	public void deleteById(Long id) {
		Optional<Vendedor> obj = repository.findById(id);
		repository.delete(obj.get());
//		repository.deleteById(id);
	}

	
}
