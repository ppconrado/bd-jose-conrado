package com.ppconrado.bdjoseconrado.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado"); 

	
	private int cod;
	private String descricao;
	
	// ENUM tipagem PRIVATE
	// ENUMsomente metodos GET
	
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	// (codigo) -> retorna obj(EstadoPagamento)
	// classe STATIC a operacao deve ser executada mesmo sem ser INSTANCIADA
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id ivalido: " + cod);
	}
}
