package com.example.decola.decola.aula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "AULA")
public class Aula {
	
	/*NÃO MEXER AQUI*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	/*FIM - NÃO MEXER AQUI*/

	@Column(name = "TEMA_AULA", length = 50, nullable = false)
	private String tema_aula;

	@Column(name = "DATA_AULA", length = 50, nullable = false)
	private String data_aula;
	
	@Column(name = "HORA_AULA", length = 50, nullable = false)
	private String hora_aula;
	
	@Column(name = "DURACAO", length = 50, nullable = false)
	private String duracao;
	
	@Column(name = "LOCAL", length = 50, nullable = false)
	private String local;
	
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;

}
