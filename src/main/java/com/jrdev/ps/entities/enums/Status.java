package com.jrdev.ps.entities.enums;

public enum Status {
	EM_PROCESSO(1),
	APROVADO(2),
	REPROVADO(3),
	DESISTIU(4);
	
	private int code;
	
	private Status(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Status valueOf(int code) {
		for (Status value : Status.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de Status invalido!");
	}
}
