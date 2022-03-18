package br.com.java.io.teste;

import java.io.IOException;
import java.io.PrintStream;

public class TestePrintStreamPrintWrite {

	public static void main(String[] args) throws IOException {
				
		PrintStream ps = new PrintStream("lorem2.txt", "UTF-8");
		
		ps.println("Gustavo Joner teste");
		ps.println();
		ps.println("Ultima linha");
		
		ps.close();
	}

}
