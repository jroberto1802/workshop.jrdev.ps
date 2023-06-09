package com.jrdev.ps.entities.enums;

public enum TipoQuestao {
	ABERTA(1),
	MUTIPLA_ESCOLHA(2);
	
	
	private int code;
	
	private TipoQuestao(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoQuestao valueOf(int code) {
		for (TipoQuestao value : TipoQuestao.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de TipoQuestao invalido!");
	}
}