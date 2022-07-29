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
import com.projeto.domain.Produto;
import com.projeto.ui.tables.ProdutoTable;

public class ProdutoVisualizaFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private JButton salvarBotao;
	private JButton editarBotao;
	private JButton fecharBotao;

	private JTextField textFieldId;
	private JTextField textFieldItem;
	private JTextField textFieldValor;
	private JTextField textFieldQuantidade;
	private JTextArea textAreaDescricao;

	ProdutoTable tablePanel;

	PresentationModel<Produto> model;

	private ProdutoTable produtoTable;
	
	public ProdutoVisualizaFrame(Produto produto, ProdutoTable produtoTable) {

		this.produtoTable = produtoTable;
		produto = DAOFactory.getProdutoDAO().getProduto(produto.getIdProduto());

		setLayout(new BorderLayout());
		initModels(produto);
		initComponents();
		initLayout();

		setTitle("Produto");
		setSize(700, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private void initModels(Produto produto) {

		model = new PresentationModel<Produto>();
		model.setBean(produto);

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

		textFieldId = BasicComponentFactory.createIntegerField(model.getModel("idProduto"));
		textFieldItem = BasicComponentFactory.createTextField(model.getModel("nomeProduto"));
		textFieldValor = BasicComponentFactory.createIntegerField(model.getModel("valorProduto"));
		textFieldQuantidade = BasicComponentFactory.createIntegerField(model.getModel("quantidadeItem"));
		textAreaDescricao = BasicComponentFactory.createTextArea(model.getModel("descricaoProduto"));

		tablePanel = new ProdutoTable();

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		textAreaDescricao.setBorder(border);

		textFieldId.setEditable(false);
		textFieldItem.setEditable(false);
		textFieldValor.setEditable(false);
		textFieldQuantidade.setEditable(false);
		textAreaDescricao.setEditable(false);

	}

	public void initLayout() {

		FormLayout layout = new FormLayout("60dlu, 10px, 0dlu:grow, 10px, 60dlu");
//		DefaultFormBuilder builder = new DefaultFormBuilder(layout, new FormDebugPanel());
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.append("Id:");
		builder.add(textFieldId, CC.xywh(3, 1, 1, 1));
		builder.nextLine();
		builder.append("Item:");
		builder.add(textFieldItem, CC.xywh(3, 3, 1, 1));
		builder.nextLine();
		builder.append("Valor:");
		builder.add(textFieldValor, CC.xywh(3, 5, 1, 1));
		builder.nextLine();
		builder.append("Quantidade:");
		builder.add(textFieldQuantidade, CC.xywh(3, 7, 1, 1));
		builder.nextLine();
		builder.append("Descrição:");
		builder.appendRow("70dlu:grow");
		builder.nextLine(2);
		builder.appendRow("0dlu");
		builder.nextLine();
		builder.append(fecharBotao);
		builder.add(editarBotao, CC.xy(5, 1));
		builder.add(salvarBotao, CC.xy(5, 13));
		builder.add(textAreaDescricao, CC.xywh(3, 9, 1, 2));

		add(builder.getPanel(), BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvarBotao) {

			DAOFactory.getProdutoDAO().save(model.getBean());

			JOptionPane.showMessageDialog(null, "  Salvo com sucesso!");
			
			dispose();	
			produtoTable.atualizaLista();
		}

		if (e.getSource() == editarBotao) {
			textAreaDescricao.setEditable(true);
			textFieldItem.setEditable(true);
			textFieldQuantidade.setEditable(true);
			textFieldValor.setEditable(true);
			textAreaDescricao.setEditable(true);

		}
	}

	private JTextField getTextFieldId() {
		return textFieldId;
	}

	private JTextField getTextFieldItem() {
		return textFieldItem;
	}

	private JTextField getTextFieldValor() {
		return textFieldValor;
	}

	private JTextField getTextFieldQuantidade() {
		return textFieldQuantidade;
	}

	public JTextArea getTextAreaDescricao() {
		return textAreaDescricao;
	}
}