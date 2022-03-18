package br.com.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscrita2 {

	public static void main(String[] args) throws IOException {
		
//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
		;
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem.txt"));
		bw.write("TESTANDO");
		bw.newLine();
		bw.write("TESTE1");
		
//		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque nisl eros");
//		bw.newLine();
//		bw.write("Gustavo");
//		
//		bw.close();
		
		bw.close();
	}

}
