package com.pdvfacility.facilityback.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_venda")
@Getter
@Setter
@AllArgsConstructor
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date = new Date();
	private String metodoPagamento;
	
	@OneToOne
	private Vendedor vendedor;
	private Long numeroFatura;
	private Double totalVenda;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToMany
    @JoinColumn(name = "venda_id") // Nome da coluna que faz a associação
	private List<ItemVenda> itens;

	@Override
	public int hashCode() {
		return Objects.hash(numeroFatura);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(numeroFatura, other.numeroFatura);
	}

}
