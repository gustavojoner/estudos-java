package br.com.bytebank.banco.teste.util;

import java.util.LinkedList;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayEquals {
	public static void main(String[] args) {
		
		List<Conta> lista = new LinkedList<Conta>(); //interface list tem linkedlist, arraylist e vector
		
		Conta cc = new ContaCorrente(11,22);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22,22);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(22,22);
		
		boolean existe = lista.contains(cc3); // Nota que cc3 nao foi adicionado a lista, porem o numero e agencia existem
		System.out.println(existe); // pois foram adicionadas em cc2, isso acontece porque equals foi sobrescrito
		
		for(Object oRef : lista) {
			System.out.println(oRef);
		}
	}
}
