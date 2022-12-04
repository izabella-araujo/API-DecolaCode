package com.example.decola.decola.aula;

public class AulaNotFoundException extends RuntimeException {
	
	AulaNotFoundException(Long id) {
		super("Aula não encontrada " + id);
	}
}
