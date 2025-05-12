package Biblioteca.Biblioteca.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class VerificaData {
	private Scanner sc = new Scanner(System.in);
	
	public LocalDate verificaData() {
		 LocalDate dataValida = null;
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 
		 do {
	            try {
	            	System.out.print("Digite a data no formato dd/MM/yyyy (ex: 15/03/2025): ");
	                String input = sc.nextLine();

	                //Converte a string para LocalDate
	                dataValida = LocalDate.parse(input, formatter);

	                System.out.println("Data cadastrada com sucesso: " + dataValida);

	            } catch (DateTimeParseException e) {
	            	System.out.println("Formato inválido ou data inexistente! Exemplo correto: 20/02/2024");
	            }
	        }while(dataValida == null);
		 
		 return dataValida;
	}
}