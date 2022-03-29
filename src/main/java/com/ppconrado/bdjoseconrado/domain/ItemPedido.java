package com.ppconrado.bdjoseconrado.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ESTA CLASSE TEM ID ItemPedidoPK 
	// Este ID eh do tipo COMPOSTO
	// Tem um atributo uma outra CLASSE
	
	@JsonIgnore // Proteger contra serialização Json cíclica 
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	private Double desconto;
	private Integer quantitade;
	private Double preco;
	
	// ASOCIACOES FORAM FEITAS na classe ItemPedidoPK
	
	public ItemPedido() {
			
		}

//	public ItemPedido(ItemPedidoPK id, Double desconto, Integer quantitade, Double preco) {
//		super();
//		this.id = id;
//		this.desconto = desconto;
//		this.quantitade = quantitade;
//		this.preco = preco;
//	}
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantitade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantitade = quantitade;
		this.preco = preco;
	}
	
	// ACESSO DIRETO AO PEDIDO E PRODUTO FORA DA CLASSE ItemPedido
	
	
	
	@JsonIgnore  // Proteger contra serialização Json cíclica 
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	
	public Produto getProduto() {
		return id.getProduto();
	}

	
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantitade() {
		return quantitade;
	}

	public void setQuantitade(Integer quantitade) {
		this.quantitade = quantitade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
