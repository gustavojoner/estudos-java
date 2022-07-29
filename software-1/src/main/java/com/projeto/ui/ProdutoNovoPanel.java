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
import com.projeto.domain.Produto;
import com.projeto.ui.util.OpenPanel;

public class ProdutoNovoPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton salvarBotao;
	JButton abrirBotao;
	JButton editarBotao;
	JButton deletarBotao;
	JButton voltarBotao;

	private JTextArea textAreaDescricao;
	private JTextField textFieldItem;
	private JTextField textFieldValor;
	private JTextField textFieldQuantidade;

	PresentationModel<Produto> model;

	public ProdutoNovoPanel() {
		setLayout(new BorderLayout());
		initModels();
		initComponents();
		initLayout();

	}

	private void initModels() {

		model = new PresentationModel<Produto>();
		model.setBean(new Produto());

	}

	private void initComponents() {

		salvarBotao = new JButton();
		abrirBotao = new JButton();
		editarBotao = new JButton();
		deletarBotao = new JButton();
		voltarBotao = new JButton(new OpenPanel(this, () -> new ProdutoInicioPanel()));

		textFieldItem = BasicComponentFactory.createTextField(model.getModel("nomeProduto"));
		textFieldValor = BasicComponentFactory.createIntegerField(model.getModel("valorProduto"));
		textFieldQuantidade = BasicComponentFactory.createIntegerField(model.getModel("quantidadeItem"));
		textAreaDescricao = BasicComponentFactory.createTextArea(model.getModel("descricaoProduto"));

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		textAreaDescricao.setBorder(border);

		salvarBotao.setText("Salvar");
		salvarBotao.addActionListener(this);

		voltarBotao.setText("Voltar");
				
	}

	public void initLayout() {

		FormLayout layout = new FormLayout("60dlu, 10px, 300dlu:grow, 10px, 60dlu");

//		DefaultFormBuilder builder = new DefaultFormBuilder(layout, new FormDebugPanel());
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);

		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.append("Item:");
		builder.add(textFieldItem, CC.xywh(3, 1, 1, 1));
		builder.nextLine();
		builder.append("Valor:");
		builder.add(textFieldValor, CC.xywh(3, 3, 1, 1));
		builder.nextLine();
		builder.append("Quantidade:");
		builder.add(textFieldQuantidade, CC.xywh(3, 5, 1, 1));
		builder.nextLine();
		builder.append("Descrição:");
		builder.appendRow("205dlu:grow");
		builder.nextLine(2);
		builder.appendRow("0dlu");
		builder.nextLine();
		builder.append(voltarBotao);
		builder.add(salvarBotao, CC.xy(5, 11));
		builder.add(textAreaDescricao, CC.xywh(3, 7, 1, 2));

		add(builder.getPanel(), BorderLayout.CENTER);

	}

	public JTextField getTextFieldItem() {
		return textFieldItem;
	}

	public JTextField getTextFieldValor() {
		return textFieldValor;
	}

	public JTextField getTextFieldQuantidade() {
		return textFieldQuantidade;
	}

	public JTextArea getTextAreaDescricao() {
		return textAreaDescricao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvarBotao) {
			
			DAOFactory.getProdutoDAO().save(model.getBean());

			JOptionPane.showMessageDialog(null, "  Salvo com sucesso!");

			model.setBean(new Produto());

		}

		if (e.getSource() == voltarBotao) {
			new OpenPanel(this, () -> new ProdutoInicioPanel());
		}

	}

}