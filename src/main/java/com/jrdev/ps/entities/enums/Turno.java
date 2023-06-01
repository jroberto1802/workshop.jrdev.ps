package com.jrdev.ps.entities.enums;

public enum Turno {
	MANHA(1),
	TARDE(2),
	NOITE(3),
	INTEGRAL(4),
	FORMADO(5),
	MANHA_TARDE(6);
	
	private int code;
	
	private Turno(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Turno valueOf(int code) {
		for (Turno value : Turno.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo de Turno invalido!");
	}
}
