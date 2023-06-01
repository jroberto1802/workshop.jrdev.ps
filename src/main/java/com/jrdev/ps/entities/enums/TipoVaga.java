package com.jrdev.ps.entities.enums;

public enum TipoVaga {
	ESTAGIO(1),
	EFETIVO(2),
	JOVEM_APRENDIZ(3);
	
	private int code;
	
	private TipoVaga(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoVaga valueOf(int code) {
		for (TipoVaga value : TipoVaga.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de TipoVaga invalido!");
	}
}
