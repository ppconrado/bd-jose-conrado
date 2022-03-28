package com.ppconrado.bdjoseconrado.domain.enums;

public enum TipoCliente {
	
	// CONTROLE MANUAL
	
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, " Pessoa Juridica");
	
	private int cod;
	private String descricao;
	
	// ENUM tipagem PRIVATE
	// ENUMsomente metodos GET
	
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	// (codigo) -> retorna obj(TipoCliente)
	// classe STATIC a operacao deve ser executada mesmo sem ser INSTANCIADA
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id ivalido: " + cod);
	}

}
