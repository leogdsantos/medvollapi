package med.voll.api.medico;

public record DadosListagemMedico(Long id, String nome, String telefone, String email, String crm, Especialidades especialidade, boolean ativo)
 {

	public DadosListagemMedico(Medico medico) {
		
		this(medico.getId(), medico.getNome(), medico.getTelefone() ,medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
	}
	
}
