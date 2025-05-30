package Biblioteca.Biblioteca.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.service.cadastro.BibliotecaServiceCadastro;

@Service
public class BibliotecaMenuCadastro {
	private Scanner sc = new Scanner(System.in);
	private int escolha = 0;
	@Autowired
	private BibliotecaServiceCadastro cadastro;
	
	public void menuCadastrar() {
		
		System.out.print("Digite o que deseja cadastrar"+"\n1- Cadastrar autor e livro"+"\n2- Cadastrar autor e artigo"+"\n3- cadastrar revista"+"\n4- Vincular Revista no artigo"+"\n-> ");
		
		try {
			escolha = sc.nextInt();
			sc.nextLine();
		}catch(InputMismatchException e) {
			sc.nextLine();
		}
		
		switch(escolha) {
		case 1:
			cadastro.cadastrarLivroEautor();
			break;
		case 2:
			cadastro.cadastrarArtigoEautor();//caso o autor já exista, vai ser puxado as informações dele para o artigo novo
			break;
		case 3:
			cadastro.cadastrarRevista();
			break;
		case 4:
			cadastro.vincularArtigoRevista();
			break;
		default:
			System.out.println("Digito invalido");
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}

