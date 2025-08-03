package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
		
		@NotBlank
		String logradouro, 
		
		@NotBlank
		String num, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		String cidade) {

}
