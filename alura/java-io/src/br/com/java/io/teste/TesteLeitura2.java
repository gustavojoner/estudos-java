package br.com.java.io.teste;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeitura2 {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(new File("conta.csv"), "UTF-8");
		
		while(scanner.hasNextLine()) {		
			String linha = scanner.nextLine();
//			System.out.println(linha);
			
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter(",");
			
			String conta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int numero = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
			
			String valorFormatado = String.format(new Locale("pt", "BR"), "%s - %04d - %d, %12s: %8.2f", 
					                                                  conta, agencia, numero, titular, saldo);
			
			System.out.println(valorFormatado);
//		String [] valores = linha.split(",");  // separa pela virgula
//		System.out.println(valores[3]);        // mostra apenas o item desejado
			
		}
		scanner.close();
	}

}
