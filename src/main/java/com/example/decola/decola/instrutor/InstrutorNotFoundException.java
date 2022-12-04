package com.example.decola.decola.instrutor;

public class InstrutorNotFoundException extends RuntimeException{

	InstrutorNotFoundException(Long id) {
		super("Instrutor não encontrado " + id);
	}
}
