package Biblioteca.Biblioteca.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaMenu {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private BibliotecaMenuCadastro comandoCadastro;
	@Autowired
	private BibliotecaMenuListagem comandoListar;
	@Autowired
	private BibliotecaMenuAtualizar comandoAtualizar;
	@Autowired
	private BibliotecaMenuExcluir comandoExcluir;
	
	
	public void menu() {	
		int escolha = 0;
		do {
			System.out.print("Digite o que deseja fazer: "+"\n1- Cadastrar"+"\n2- Exibir"+"\n3- Atualizar"+"\n4- Excluir"+"\n5- Encerrar programa"+"\n-> ");
			
			try {
				escolha = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				sc.nextLine();
			}
			
			switch(escolha) {
			case 1:
				comandoCadastro.menuCadastrar();
				break;
			case 2:
				comandoListar.menuListagem();
				break;
			case 3:
				comandoAtualizar.menuAtualizar();
				break;
			case 4:
				comandoExcluir.menuExcluirLivro();
				break;
			case 5:
				break;
				default:
				System.out.println("Digito invalido");
			}
			escolha = 0;
		}while(escolha != 5);
		System.out.println("Programa encerrado");
	}
}