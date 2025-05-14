package Biblioteca.Biblioteca.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.service.atualizacao.BibliotecaServiceAtualizar;

@Service
public class BibliotecaMenuAtualizar {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private BibliotecaServiceAtualizar atualizar;
	private int escolha = 0;
	public void menuAtualizar() {
		System.out.print("Digite o que deseja atualizar"+"\n1- Genero do livro"+"\n2- Titulo do livro"+"\n3- Editora do livro"+"\n4- Data de publicaçao do livro"+
	"\n5- Nome e sobrenome de um autor"+"\n6- Data de nascimento de um autor"+"\n7- Nacionalidade do autor"+"\n8- Editar editora da revista"+"\n9- Editar titulo do artigo"+
				"\n10- Editar Texto de publicação do artigo"+"\n-> ");
		
		try {
			escolha = sc.nextInt();
			sc.nextLine();
		}catch(InputMismatchException e) {
			sc.nextLine();
		}
		switch(escolha){		
		case 1:
			atualizar.atualizaLivroGenero();
			break;
		case 2:
			atualizar.atualizaLivroTitulo();
			break;
		case 3:
			atualizar.atualizaLivroEditora();
			break;
		case 4:
			atualizar.atualizarLivroDataPublicacao();
			break;
		case 5:
			atualizar.atualizarNomeDoAutor();
			break;
		case 6:
			atualizar.atualizarDataNascimentoAutor();
			break;
		case 7:
			atualizar.atualizarNacionalidadeAutor();
			break;
		case 8:
			atualizar.atualizarEditoraRevista();
			break;
		case 9:
			atualizar.atualizarArtigoTitulo();
			break;
		case 10:
			atualizar.atualizarArtigoTexto();
			break;
		default:
			System.out.println("Numero invalido");
		}
	}
}