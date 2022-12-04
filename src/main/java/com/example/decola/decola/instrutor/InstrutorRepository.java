package com.example.decola.decola.instrutor;

import org.springframework.data.jpa.repository.JpaRepository;
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
	Instrutor findByEmailAndSenha(String email, String senha);
}


