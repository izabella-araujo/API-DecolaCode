package com.example.decola.decola.aluno;

public class AlunoNotFoundException extends RuntimeException {
	
	AlunoNotFoundException(Long id) {
		super("Aluno não encontrado " + id);
	}
}
