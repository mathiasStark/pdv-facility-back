package com.pdvfacility.facilityback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdvfacility.facilityback.entities.Vendedor;
import com.pdvfacility.facilityback.services.VendedorService;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService service;
	
	@PostMapping
	public ResponseEntity<Vendedor> insertVendedor(@RequestBody Vendedor vendedor) {
		Vendedor entity = service.insert(vendedor);
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Vendedor>> getAllVendedores() {
		List<Vendedor> vendedores = service.findAll();
		return ResponseEntity.ok(vendedores);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Vendedor> update(@PathVariable Long id, @RequestBody Vendedor vendedor) {
		Vendedor entity = service.updateVendedor(id, vendedor);
		return ResponseEntity.ok(entity);	
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deletarVendedor(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
