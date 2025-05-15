package Biblioteca.Biblioteca.service.cadastro;


import java.time.LocalDate;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.AutorModel;
import Biblioteca.Biblioteca.repository.AutorRepository;
import Biblioteca.Biblioteca.service.VerificaData;

@Service
public class CadastroAutor {
	@Autowired
    private AutorRepository autorRepository;
	private Scanner sc = new Scanner(System.in);
	private VerificaData verificaData = new VerificaData();
	
    
    public AutorModel adicionarAutoresNaLista() {
    	AutorModel autor = null;
    	
    	System.out.print("Digite o nome completo do autor -> ");
    	String nomeCompleto = sc.nextLine().toUpperCase().trim();
    	

    	if(this.verificaSeNomeJaExiste(nomeCompleto)) {
    		return autor = this.autorRepository.cadastrarCacheDeAutor(nomeCompleto);//se o nome existir, vai trazer de volta os dados desse autor, para nao precisar cadastrar novamente 
    	}else {
    		autor = new AutorModel(nomeCompleto, this.CadastraData(), this.cadastraNacionalidade().toUpperCase());
    	}
    	
    	return autor;
    }
    
    
    private Boolean verificaSeNomeJaExiste(String nomeCompleto) {
    	
    	if(this.autorRepository.findByNomeCompleto(nomeCompleto).isPresent()) {
    		return true;
    	}
    	return false;
    }
  
    
    private LocalDate CadastraData() {
		return this.verificaData.verificaData();
    }
    
    private String cadastraNacionalidade() {
    	System.out.print("Digite a nacionalidade do autor -> ");
    	return sc.nextLine().toUpperCase().trim();
    }
}