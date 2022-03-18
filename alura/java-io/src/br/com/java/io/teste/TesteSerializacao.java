package br.com.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		String nome = "Gustavo";
//		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//		oss.writeObject(nome);
//		oss.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		String nome = (String) ois.readObject();
		System.out.println(nome);
	}

}
