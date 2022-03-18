package br.com.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Gustavo Joner");
//		cliente.setProfissao("Arquiteto");
//		cliente.setCpf("46542315");
//		
//		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//		oss.writeObject(cliente);
//		oss.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
		Cliente cliente = (Cliente) ois.readObject();
		ois.close();
		System.out.println(cliente.getNome());
	}
}
