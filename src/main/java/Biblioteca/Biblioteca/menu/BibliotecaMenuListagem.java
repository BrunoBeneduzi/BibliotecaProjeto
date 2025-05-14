package Biblioteca.Biblioteca.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.service.listagem.BibliotecaServiceListagem;

@Service
public class BibliotecaMenuListagem {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private BibliotecaServiceListagem listar;
	private int escolha = 0;
	public void menuListagem() {
		System.out.print("Digite o que deseja exibir"+"\n1- Exibir todos os autores"+"\n2- Exibir todos os livros"+"\n3- Exibir todos os autores com livros vinculados"+
	"\n4- Filtrar e exibir livros por Titulo"+"\n5- Filtrar e exibir livros por Genero"+"\n6- Filtrar e exibir livros por sobrenome do autor"+
				"\n7- Exibir revistas"+"\n8- Exibir artigos"+"\n9- Filtrar e exibir revistas por nome ou sobrenome dos autores"+"\n-> ");
		
		try {
			escolha = sc.nextInt();
			sc.nextLine();
		}catch(InputMismatchException e) {
			sc.nextLine();
		}
		
		switch(escolha) {
		case 1:
			listar.listarAutores();
			break;
		case 2:
			listar.listarLivros();
			break;
		case 3:
			listar.listarLivrosVinculadosNoAutor();
			break;
		case 4:
			listar.listarLivroPorTitulo();
			break;
		case 5:
			listar.listarLivroPorGenero();
			break;
		case 6:
			listar.listarAutorPorNomeSobrenome();
			break;
		case 7:
			listar.listarRevistas();
			break;
		case 8:
			listar.listarArtigos();
			break;
		case 9:
			listar.listarRevistasPorSobreNomeDoAutor();//faz o filtro verificando quais revistas tem artigos vinculados a um autor, ou seja, se a revista tem 3 artigos de 3 autores diferentes, vai exibir a revista e os autores
			break;
		default:
			System.out.println("Numero invalido");
		}
	}
}