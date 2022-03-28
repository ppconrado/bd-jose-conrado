package com.ppconrado.bdjoseconrado.domain;

import javax.persistence.Entity;

import com.ppconrado.bdjoseconrado.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}
	
	// Sub classe - Baseado na Superclasse -  super() heranca

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
}
