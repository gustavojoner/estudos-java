package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

import com.projeto.dao.DAOFactory;
import com.projeto.domain.Cliente;
import com.projeto.ui.util.OpenPanel;

public class ClienteNovoPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton salvarBotao;
	JButton abrirBotao;
	JButton editarBotao;
	JButton deletarBotao;
	JButton voltarBotao;

	private JTextField textFieldNome;
	private JTextField textFieldContato;
	private JTextArea textAreaObs;

	PresentationModel<Cliente> model;

	public ClienteNovoPanel() {
		setLayout(new BorderLayout());
		initModels();
		initComponents();
		initLayout();
	}

	private void initModels() {

		model = new PresentationModel<Cliente>();
		model.setBean(new Cliente());

	}

	private void initComponents() {

		salvarBotao = new JButton();
		abrirBotao = new JButton();
		editarBotao = new JButton();
		deletarBotao = new JButton();
		voltarBotao = new JButton(new OpenPanel(this, () -> new ClienteInicioPanel()));

		textFieldNome = BasicComponentFactory.createTextField(model.getModel("nomeCliente"));
		textFieldContato = BasicComponentFactory.createLongField(model.getModel("contatoCliente"));
		textAreaObs = BasicComponentFactory.createTextArea(model.getModel("obsCliente"));

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		textAreaObs.setBorder(border);

		salvarBotao.setText("Salvar");
		salvarBotao.addActionListener(this);

		voltarBotao.setText("Voltar");
		
	}

	public void initLayout() {

		FormLayout layout = new FormLayout("60dlu, 10px, 300dlu:grow, 10px, 60dlu");

//		DefaultFormBuilder builder = new DefaultFormBuilder(layout, new FormDebugPanel());
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);

		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.append("Nome:");
		builder.add(textFieldNome, CC.xywh(3, 1, 1, 1));
		builder.nextLine();
		builder.append("Contato:");
		builder.add(textFieldContato, CC.xywh(3, 3, 1, 1));
		builder.nextLine();
		builder.append("Observação:");
		builder.appendRow("205dlu:grow");
		builder.nextLine(2);
		builder.appendRow("0dlu");
		builder.nextLine();
		builder.append(voltarBotao);
		builder.add(salvarBotao, CC.xy(5, 9));
		builder.add(textAreaObs, CC.xywh(3, 5, 1, 2));

		add(builder.getPanel(), BorderLayout.CENTER);

	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldContato() {
		return textFieldContato;
	}

	public JTextArea getTextAreaObs() {
		return textAreaObs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvarBotao) {

			DAOFactory.getClienteDAO().save(model.getBean());

			JOptionPane.showMessageDialog(null, "  Salvo com sucesso!");

			model.setBean(new Cliente());

		}

		if (e.getSource() == voltarBotao) {
			new OpenPanel(this, () -> new ClienteInicioPanel());
		}

	}

}