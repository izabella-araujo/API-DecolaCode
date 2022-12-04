package com.example.decola.decola.aula;

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
public class ControllerAula {
	private final AulaRepository repository;

	ControllerAula(AulaRepository repository) {
		this.repository = repository;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/aulas")
	List<Aula> listarAulas() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/novaaula")
	Aula novaAula(@RequestBody Aula aula) {
		return repository.save(aula);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getaula/{id}")
	Aula getAula(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new AulaNotFoundException(id));
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/atualizaraula/{id}")
	Aula atualizarAula(@RequestBody Aula novaAula, @PathVariable Long id) {
		return repository.findById(id).map(aula -> {
			aula.setTema_aula(novaAula.getTema_aula());
			aula.setData_aula(novaAula.getData_aula());
			aula.setHora_aula(novaAula.getHora_aula());
			aula.setDuracao(novaAula.getDuracao());
			aula.setLocal(novaAula.getLocal());
			aula.setDescricao(novaAula.getDescricao());
			return repository.save(aula);
		}).orElseGet(() -> {
			novaAula.setId(id);
			return repository.save(novaAula);
		});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/removeraula/{id}")
	void removerAula(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
