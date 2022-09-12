package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.projeto.dao.DAOFactory;
import com.projeto.domain.Usuario;
import com.projeto.ui.util.Icones;

public class LoginNovoFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel(new BorderLayout());
	JMenuBar menu = new JMenuBar();
	JLabel usuarioTxt;
	JLabel senhaTxt;
	JLabel criado;
	JLabel naoCriado;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldSenha;
	JButton salvarBotao;
	JButton voltarBotao;
	JButton sairBotao;
	DefaultFormBuilder builder;
	PresentationModel<Usuario> model;
	Icones icone = new Icones();

	public LoginNovoFrame() {

		setTitle("System Gustavo");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setJMenuBar(menu);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initModels();
		initComponents();
		initLayout();
	}

	private void initModels() {

		model = new PresentationModel<Usuario>();
		model.setBean(new Usuario());

	}
	
	private void initComponents() {
		
		sairBotao = new JButton();
		sairBotao.setIcon(icone.getExitIcon());
		sairBotao.setBorderPainted(false);
		sairBotao.setContentAreaFilled(false);
		sairBotao.addActionListener(e -> System.exit(0));
		sairBotao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		menu.setLayout(new BorderLayout());
		menu.setBorderPainted(false);
		menu.add(sairBotao, BorderLayout.EAST);

		usuarioTxt = new JLabel("Usuário", SwingConstants.LEFT);
		senhaTxt = new JLabel("Senha", SwingConstants.LEFT);
		criado = new JLabel("Criado com Sucesso!", SwingConstants.CENTER);
		naoCriado = new JLabel("Usuário já existe", SwingConstants.CENTER);
		criado.setVisible(false);
		naoCriado.setVisible(false);

		salvarBotao = new JButton();
		salvarBotao.setText("Salvar");
		salvarBotao.addActionListener(this);

		voltarBotao = new JButton();
		voltarBotao.setText("Voltar");
		voltarBotao.addActionListener(this);
		
		textFieldUsuario = BasicComponentFactory.createTextField(model.getModel("loginUsuario"));
		textFieldSenha = BasicComponentFactory.createPasswordField(model.getModel("senhaUsuario"));
		
	}

	public void initLayout() {

		FormLayout layout = new FormLayout("5dlu:grow, 10px, 100dlu, 10px, 5dlu:grow",
				"15dlu:grow, 7dlu, 3px, 15dlu, 10px, 7dlu, 3px, 15dlu,0dlu:grow, 15dlu, 0dlu:grow, 15dlu, 10px, 15dlu");

//		builder = new DefaultFormBuilder(layout, new FormDebugPanel());
		builder = new DefaultFormBuilder(layout);

		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.add(usuarioTxt, CC.xy(3, 2));
		builder.add(textFieldUsuario, CC.xy(3, 4));

		builder.add(senhaTxt, CC.xy(3, 6));
		builder.add(textFieldSenha, CC.xy(3, 8));

		builder.add(criado, CC.xy(3, 10));
		builder.add(naoCriado, CC.xy(3, 10));

		builder.add(salvarBotao, CC.xy(3, 12));
		builder.add(voltarBotao, CC.xy(3, 14));

		panel.add(builder.getPanel(), BorderLayout.CENTER);
		add(panel);
		revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvarBotao) {

			DAOFactory.getUsuarioDAO().save(model.getBean());
			model.setBean(new Usuario());
			
			criado.setVisible(true);
			textFieldUsuario.setText(null);
			textFieldSenha.setText(null);

			
		} else if (e.getSource() == voltarBotao) {
			dispose();
		}
	}

}
