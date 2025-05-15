package Biblioteca.Biblioteca.service.cadastro;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Biblioteca.Biblioteca.model.RevistaModel;
import Biblioteca.Biblioteca.repository.RevistaReposiroty;
import Biblioteca.Biblioteca.service.VerificaData;

@Service
public class CadastroRevista {
	private Scanner sc = new Scanner(System.in);
	private VerificaData Verificadata = new VerificaData();
	@Autowired
	private RevistaReposiroty revistaReposiroty;
	
	
	
	private RevistaModel adicionarRevistaNaLista() {
		RevistaModel revista = null;
    	
    	String nomeEditora = this.cadastrarNomeEditora();
    	int numEdicao = this.cadastraNumeroDeEdicao(nomeEditora);
    
    	revista = new RevistaModel(nomeEditora, numEdicao, this.cadastraData());	
		return revista;
	}
	
	  public RevistaModel cacheRevista() {
			String nomeEditora = this.cadastrarNomeEditora();
			
			System.out.print("Digite o numero da edição -> ");
			int numEdicao = sc.nextInt();
			
			if(this.revistaReposiroty.findByEditoraAndNumeroDeEdicao(nomeEditora, numEdicao).isPresent()) {
				return this.revistaReposiroty.findByEditoraAndNumeroDeEdicao(nomeEditora, numEdicao).get();
			}
			return null;
			
		}
	
	public void cadastroRevista() {
    	this.revistaReposiroty.save(this.adicionarRevistaNaLista());
    }
    
    
    private LocalDate cadastraData() {
		return this.Verificadata.verificaData();
    }
    
    private String cadastrarNomeEditora() {
    	System.out.print("Digite o nome da editora-> ");
    	return sc.nextLine().toUpperCase().trim();
    }
   
  
   private int cadastraNumeroDeEdicao(String editora) {
	   Boolean verifica = true;
	   int numEdicao = 0;
	   
	   System.out.print("Digite o numero da edição -> ");
	   
	   do {
		   try {
			   numEdicao = sc.nextInt();
				   if(this.revistaReposiroty.findByEditoraAndNumeroDeEdicao(editora, numEdicao).isPresent()) {
					   System.out.print("Numero de edição já cadastrado, tente novamente -> ");
					   sc.nextLine();
				   }else {
					   verifica = false;
				   }
		   }catch(InputMismatchException e) {
			   System.out.print("Digite um numero valido -> ");
			   sc.nextLine();
		   }
		     
	   }while(verifica);
	   
	   return numEdicao;
   }
	
}