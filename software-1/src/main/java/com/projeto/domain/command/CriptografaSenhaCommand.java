package com.projeto.domain.command;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografaSenhaCommand {

	private String senha;
	
	public CriptografaSenhaCommand(String senha) {
		this.senha = senha;
	}
	
	public String execute() {
		
		try {
			
			MessageDigest m = MessageDigest.getInstance("MD5");
		    m.update(senha.getBytes(), 0, senha.length());
		    BigInteger senhaCript = new BigInteger(1, m.digest());
		    senha = String.format("%1$032X", senhaCript);
		    
			return senha;
			
		} catch (Exception e) {
			
			System.out.println("Erro ao criptografar: " + e);
			
			return "";
		}
	}
}
