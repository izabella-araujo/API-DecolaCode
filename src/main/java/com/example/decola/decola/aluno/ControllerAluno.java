package com.example.decola.decola.aluno;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerAluno {
	private final AlunoRepository repository;

	ControllerAluno(AlunoRepository repository) {
		this.repository = repository;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/alunos")
	List<Aluno> listarAlunos() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/novoaluno")
	Aluno novoAluno(@RequestBody Aluno aluno) {
		return repository.save(aluno);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getaluno/{id}")
	Aluno getAluno(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/atualizaraluno/{id}")
	Aluno atualizarAluno(@RequestBody Aluno novoAluno, @PathVariable Long id) {
		return repository.findById(id).map(aluno -> {
			aluno.setNome(novoAluno.getNome());
			aluno.setEmail(novoAluno.getEmail());
			aluno.setSenha(novoAluno.getSenha());
			return repository.save(aluno);
		}).orElseGet(() -> {
			novoAluno.setId(id);
			return repository.save(novoAluno);
		});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/removeraluno/{id}")
	void removerAluno(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
