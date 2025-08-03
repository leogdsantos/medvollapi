package med.voll.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;


@Table (name = "paciente")
@Entity (name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Paciente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome; 
	private String email; 
	private String telefone;  
	private Boolean ativo;
	
	@Embedded
	private Endereco endereco; 
	
	public Paciente (DadosCadastroPaciente dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.endereco = new Endereco(dados.endereco());
		
	}

	public Paciente(Long id, String nome, String email, String telefone, Endereco endereco,  Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.ativo = ativo;
	}

	public Paciente() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void atulizaInformacoes(DadosAtulizacaoPaciente dados) {
		
		if(dados.nome()!=null) {
			this.nome = dados.nome();
		}
		if(dados.telefone()!=null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco()!=null) {
			this.endereco.atulizarInformacoes(dados.endereco()); 
		}
	}
	public void excluir() {
		this.ativo = false; 
	}
}
