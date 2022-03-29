package com.ppconrado.bdjoseconrado.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// Classe de ASSOCIACAO NAO TEM ID
// CLASSE COMPOSTA DOD IDs DO PEDIDO e PRODUTO
// Tem um atributo uma outra CLASSE e devemos colocar anotacao Embeddable
// colocar anotacao Embeddable para dizer que eh um SUB-TITULO


@Embeddable 
public class ItemPedidoPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// REFERENCIAS DO PRODUTO E PEDIDO
	
	@ManyToOne // UM Pedido e UM Produto -> Muitos para um
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne // UM Pedido e UM Produto -> Muitos para um
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}
	
	
	
}
