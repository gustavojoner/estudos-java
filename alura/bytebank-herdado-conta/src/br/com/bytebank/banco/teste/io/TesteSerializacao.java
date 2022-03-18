package br.com.bytebank.banco.teste.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteSerializacao {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Cliente cliente = new Cliente();
		cliente.setNome("Gustavo Joner");
		cliente.setProfissao("Arquiteto");
		cliente.setCpf("46542315");
		
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(500);
		cc.setTitular(cliente);
		
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("cc.bin"));
		oss.writeObject(cc);
		oss.close();

	}

}
