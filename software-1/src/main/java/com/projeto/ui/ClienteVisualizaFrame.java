package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import com.projeto.ui.tables.ClienteTable;

public class ClienteVisualizaFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private JButton salvarBotao;
	private JButton editarBotao;
	private JButton fecharBotao;

	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldContato;
	private JTextArea textAreaObs;

	ClienteTable tablePanel;

	PresentationModel<Cliente> model;

	private ClienteTable clienteTable;

	public ClienteVisualizaFrame(Cliente cliente, ClienteTable clienteTable) {
		
		this.clienteTable = clienteTable;
		cliente = DAOFactory.getClienteDAO().getCliente(cliente.getIdCliente());

		setLayout(new BorderLayout());
		initModels(cliente);
		initComponents();
		initLayout();
		tablePanel.atualizaLista();

		setTitle("Cliente");
		setSize(700, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private void initModels(Cliente cliente) {

		model = new PresentationModel<Cliente>();
		model.setBean(cliente);

	}

	private void initComponents() {

		panel = new JPanel(new BorderLayout());

		salvarBotao = new JButton();
		salvarBotao.setText("Salvar");
		salvarBotao.addActionListener(this);

		editarBotao = new JButton();
		editarBotao.setText("Editar");
		editarBotao.addActionListener(this);

		fecharBotao = new JButton();
		fecharBotao.setText("Fechar");
		fecharBotao.addActionListener(e -> dispose());

		textFieldId = BasicComponentFactory.createIntegerField(model.getModel("idCliente"));
		textFieldNome =  BasicComponentFactory.createTextField(model.getModel("nomeCliente"));
		textFieldContato = BasicComponentFactory.createLongField(model.getModel("contatoCliente"));
		textAreaObs = BasicComponentFactory.createTextArea(model.getModel("obsCliente"));

		tablePanel = new ClienteTable();

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		textAreaObs.setBorder(border);

		textFieldId.setEditable(false);
		textFieldNome.setEditable(false);
		textFieldContato.setEditable(false);
		textAreaObs.setEditable(false);

	}

	public void initLayout() {

		FormLayout layout = new FormLayout("60dlu, 10px, 0dlu:grow, 10px, 60dlu");
//		DefaultFormBuilder builder = new DefaultFormBuilder(layout, new FormDebugPanel());
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.append("Id:");
		builder.add(textFieldId, CC.xywh(3, 1, 1, 1));
		builder.nextLine();
		builder.append("Nome:");
		builder.add(textFieldNome, CC.xywh(3, 3, 1, 1));
		builder.nextLine();
		builder.append("Contato:");
		builder.add(textFieldContato, CC.xywh(3, 5, 1, 1));
		builder.nextLine();
		builder.append("Observação:");
		builder.appendRow("70dlu:grow");
		builder.nextLine(2);
		builder.appendRow("0dlu");
		builder.nextLine();
		builder.append(fecharBotao);
		builder.add(editarBotao, CC.xy(5, 1));
		builder.add(salvarBotao, CC.xy(5, 11));
		builder.add(textAreaObs, CC.xywh(3, 7, 1, 2));

		add(builder.getPanel(), BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvarBotao) {
			
			DAOFactory.getClienteDAO().save(model.getBean());

			JOptionPane.showMessageDialog(null, "  Salvo com sucesso!");
			
			dispose();
			clienteTable.atualizaLista();

		}

		if (e.getSource() == editarBotao) {
			textFieldNome.setEditable(true);
			textFieldContato.setEditable(true);

		}
	}

	public JTextArea getTextAreaObs() {
		return textAreaObs;
	}

	private JTextField getTextFieldId() {
		return textFieldId;
	}

	private JTextField getTextFieldNome() {
		return textFieldNome;
	}

	private JTextField getTextFieldContato() {
		return textFieldContato;
	}
}