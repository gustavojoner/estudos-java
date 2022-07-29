package com.projeto.domain.command;

import javax.swing.JOptionPane;

import com.projeto.dao.DAOFactory;
import com.projeto.ui.MainFrame;

public class ValidaSenhaCommand implements Command{

	private String login;
	private String senha;
	private String senhaUser;
	private String senhaCript;
	
	public ValidaSenhaCommand(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public void execute() {
		
		senhaUser = DAOFactory.getUsuarioDAO().findByLogin(login).getSenhaUsuario();
		senhaCript = new CriptografaSenhaCommand(senha).execute();
		
		if (senhaUser.equals(senhaCript)) {
			
			new MainFrame();

		} else {

			JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!");

		}
	}
}
