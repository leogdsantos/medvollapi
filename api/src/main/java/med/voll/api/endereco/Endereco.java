package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro; // Corrigido aqui
    private String num;
    private String bairro;
    private String cidade;

    public Endereco() {
    }
    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro(); // Corrigido aqui também
        this.num = dados.num();
        this.bairro = dados.bairro(); 
        this.cidade = dados.cidade(); 
    }
    
    public void atulizarInformacoes(DadosEndereco dados) {
    	
    	if(dados.logradouro()!=null) {
    		this.logradouro = dados.logradouro();
    	}
    	if(dados.num()!=null) {
    		this.num = dados.num();
    	}
    	if(dados.bairro()!=null) {
    		this.bairro = dados.bairro();
    	}
    	if(dados.cidade()!= null) {
    		this.cidade = dados.cidade();
    	}
    }
}

