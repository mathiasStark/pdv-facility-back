package com.pdvfacility.facilityback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdvfacility.facilityback.entities.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

	Vendedor save(Vendedor vendedor);

}
