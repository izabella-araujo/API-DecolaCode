package com.example.decola.decola.instrutor;

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
public class ControllerInstrutor {

	private final InstrutorRepository repository;

	ControllerInstrutor(InstrutorRepository repository) {
		this.repository = repository;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/listar")
	List<Instrutor> listar() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/cadastrar")
	Instrutor cadastrar(@RequestBody Instrutor instrutor) {
		return repository.save(instrutor);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/get/{id}")
	Instrutor get(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new InstrutorNotFoundException(id));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/login")
	InstrutorLogin login(@RequestBody InstrutorLogar instrutor) {
		Instrutor d = repository.findByEmailAndSenha(instrutor.getLogin(), instrutor.getSenha());
		InstrutorLogin d2 = new InstrutorLogin();
		d2.setSenha(d.getSenha());
		return d2; 
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/atualizar/{id}")
	Instrutor atualizar(@RequestBody Instrutor instrutorNovo, @PathVariable Long id) {
		return repository.findById(id).map(instrutor -> {
			instrutor.setNome(instrutorNovo.getNome());
			instrutor.setEmail(instrutorNovo.getEmail());
			instrutor.setInstituicao(instrutorNovo.getInstituicao());
			instrutor.setMatricula(instrutorNovo.getMatricula());
			instrutor.setSenha(instrutorNovo.getSenha());
			return repository.save(instrutor);
		}).orElseGet(() -> {
			instrutorNovo.setId(id);
			return repository.save(instrutorNovo);
		});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/remover/{id}")
	void remover(@PathVariable Long id) {
		repository.deleteById(id);
	}
}


