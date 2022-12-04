package com.example.decola.decola.aluno;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "ALUNO")
public class Aluno {
	
	/*NÃO MEXER AQUI*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	/*FIM - NÃO MEXER AQUI*/

	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;
	
	@Column(name = "SENHA", length = 50, nullable = false)
	private String senha;

}
