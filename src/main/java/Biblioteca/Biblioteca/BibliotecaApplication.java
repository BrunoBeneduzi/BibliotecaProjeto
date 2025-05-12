package Biblioteca.Biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Biblioteca.Biblioteca.menu.BibliotecaMenu;
import Biblioteca.Biblioteca.service.cadastro.CadastraAutorEartigo;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner{
	@Autowired
	private	BibliotecaMenu bibliotecaMenu;
	@Autowired 
	private CadastraAutorEartigo popularBanco;

	
	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			popularBanco.popularBanco();//colocando dados no banco de dados
		}catch(Exception e) {
			
		}/*se já rodou o codigo 1 vez e tentar rodar de novo, vai dar erro dizendo que já existe os dados na tabela, aqui só impede de travar o programa
		Não é o ideal, tentei usar o flyway, mas apareceu um erro dizendo que ele não era suportado para essa versão do postgreSQL.
		*/
		
		
		bibliotecaMenu.menu();
	}

}
