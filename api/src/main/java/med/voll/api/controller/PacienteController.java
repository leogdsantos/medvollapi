package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosAtulizacaoPaciente;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosListagemPacientes;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
		repository.save(new Paciente(dados));
		System.out.println(dados); 
	}

	@GetMapping
	public Page<DadosListagemPacientes> listar(Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemPacientes::new); 
	}
	
	@PutMapping
	@Transactional
	public void atulizar(@RequestBody @Valid DadosAtulizacaoPaciente dados) {
		
		var paciente = repository.getReferenceById(dados.id()); 
		paciente.atulizaInformacoes(dados);
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		
		var paciente = repository.getReferenceById(id);
		paciente.excluir(); 
		
	}
}
