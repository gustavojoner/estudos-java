package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.projeto.domain.command.ValidaSenhaCommand;

public class LoginFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel(new BorderLayout());

	JButton loginBotao;
	JButton criarBotao;

	JLabel usuarioTxt;
	JLabel senhaTxt;

	private JTextField textFieldUsuario;
	private JPasswordField textFieldSenha;

	JCheckBox guardaUsuario;
	DefaultFormBuilder builder;

	public LoginFrame() {

		setTitle("System Gustavo");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
		initLayout();
	}

	public void initComponents() {

		loginBotao = new JButton();
		loginBotao.setText("Login");
		loginBotao.addActionListener(this);

		criarBotao = new JButton();
		criarBotao.addActionListener(this);
		criarBotao.setText("Cadastrar-se");
		criarBotao.setForeground(Color.GRAY);
		criarBotao.setBorderPainted(false);
		criarBotao.setContentAreaFilled(false);
		criarBotao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				criarBotao.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		usuarioTxt = new JLabel("Usuário", SwingConstants.LEFT);
		senhaTxt = new JLabel("Senha", SwingConstants.LEFT);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setForeground(Color.GRAY);
		textFieldSenha = new JPasswordField();

		guardaUsuario = new JCheckBox();
		guardaUsuario.setText("Lembrar-me");
		guardaUsuario.setToolTipText("Deixa o usuário e senhas salvos");

	}

	public void initLayout() {

		FormLayout layout = new FormLayout("5dlu:grow, 10px, 100dlu, 10px, 5dlu:grow",
				"15dlu:grow, 7dlu, 3px, 15dlu, 10px, 7dlu, 3px, 15dlu, 3px, 15dlu, 100dlu:grow, 15dlu, 10px, 15dlu");

//		builder = new DefaultFormBuilder(layout, new FormDebugPanel());
		builder = new DefaultFormBuilder(layout);

		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.add(usuarioTxt, CC.xy(3, 2));
		builder.add(textFieldUsuario, CC.xy(3, 4));

		builder.add(senhaTxt, CC.xy(3, 6));
		builder.add(textFieldSenha, CC.xy(3, 8));

		builder.add(guardaUsuario, CC.xy(3, 10));

		builder.add(loginBotao, CC.xy(3, 12));
		builder.add(criarBotao, CC.xy(3, 14));

		panel.add(builder.getPanel(), BorderLayout.CENTER);
		add(panel);
		revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBotao) {

			new ValidaSenhaCommand(textFieldUsuario.getText(), textFieldSenha.getText()).execute();

		} else if (e.getSource() == criarBotao) {

			new LoginNovoFrame();

		}
	}
}
