package com.dougFerreira.Geramb.models;

public enum ProfileType {

	GESTOR(1, "ROLE_GESTOR"), DOCENTE(2, "ROLE_DOCENTE"), ALUNO(2, "ROLE_ALUNO"), SEM_PERMISSAO(3, "ROLE_SEM_PERMISSAO");
	
	private long cod;
	private String description;

	private ProfileType(long cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public long getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static ProfileType toEnum(String description) {
		if (description == null) {
			return null;
		}
		for (ProfileType x : ProfileType.values()) {
			if (description.equals(x.getDescription())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Invalid profile");
	}
}
