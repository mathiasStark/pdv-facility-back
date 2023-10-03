package com.pdvfacility.facilityback.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_item_venda")
@Getter
@Setter
@AllArgsConstructor
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToMany
    @JoinTable(
        name = "tb_item_produto", // Nome da tabela de junção
        joinColumns = @JoinColumn(name = "item_venda_id"), // Coluna que referencia o ItemVenda
        inverseJoinColumns = @JoinColumn(name = "produto_id") // Coluna que referencia o Produto
    )
	private Set<Produto> produtos;
    
	private Long quantidadeVendida;
	private Double totalItem;
	
}
