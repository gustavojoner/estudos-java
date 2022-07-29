package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.projeto.dao.DAOFactory;
import com.projeto.domain.Venda;
import com.projeto.ui.tables.HistoricoTable;
import com.projeto.ui.tables.VendaTable;

public class HistoricoVisualizaVendaFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel panel;

	JButton salvarBotao;
	JButton editarBotao;
	JButton fecharBotao;

	JTextField textFieldId;
	JTextField textFieldIdProduto;
	JTextField textFieldNomeProduto;
	JTextField textFieldQuantidade;
	JTextField textFieldIdCliente;

	VendaTable tablePanel;
	
	private VendaTable tableModel;
	
	PresentationModel<Venda> model;

	Venda venda = new Venda();

	private HistoricoTable historicoTable;
	
	public HistoricoVisualizaVendaFrame(Venda venda, HistoricoTable historicoTable) {

		this.historicoTable = historicoTable;
		venda = DAOFactory.getVendaDAO().getVenda(venda.getIdVenda());
		
		setLayout(new BorderLayout());
		initModels(venda);
		initComponents();
		initLayout();

		setTitle("Produto");
		setSize(700, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	private void initModels(Venda venda) {

		model = new PresentationModel<Venda>();
		model.setBean(venda);

	}


	private void initComponents() {

		panel = new JPanel(new BorderLayout());
		
		salvarBotao = new JButton();
		salvarBotao.setText("Salvar");
		salvarBotao.addActionListener(this);

		fecharBotao = new JButton();
		fecharBotao.setText("Fechar");
		fecharBotao.addActionListener(e -> dispose());

		editarBotao = new JButton();
		editarBotao.setText("Editar");
		editarBotao.addActionListener(this);

		textFieldId = BasicComponentFactory.createIntegerField(model.getModel("idVenda"));
		textFieldIdProduto = BasicComponentFactory.createIntegerField(model.getModel("idProdutoVendido"));
		textFieldNomeProduto = BasicComponentFactory.createTextField(model.getModel("nomeProduto"));		
		textFieldIdCliente = BasicComponentFactory.createIntegerField(model.getModel("idCliente"));
		textFieldQuantidade = BasicComponentFactory.createIntegerField(model.getModel("quantidadeVenda"));
		
		textFieldId.setEditable(false);
		textFieldIdProduto.setEditable(false);
		textFieldNomeProduto.setEditable(false);
		textFieldIdCliente.setEditable(false);
		textFieldQuantidade.setEditable(false);
		
		tablePanel = new VendaTable();
	}

	public void initLayout() {

		FormLayout layout = new FormLayout("60dlu, 10px, 0dlu:grow, 10px, 60dlu");
//		DefaultFormBuilder builder = new DefaultFormBuilder(layout, new FormDebugPanel());
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.append("ID Venda:");
		builder.add(textFieldId, CC.xywh(3, 1, 1, 1));
		builder.nextLine();
		builder.append("ID Produto:");
		builder.add(textFieldIdProduto, CC.xywh(3, 3, 1, 1));
		builder.nextLine();
		builder.append("Produto:");
		builder.add(textFieldNomeProduto, CC.xywh(3, 5, 1, 1));
		builder.nextLine();
		builder.append("ID Cliente:");
		builder.add(textFieldIdCliente, CC.xywh(3, 7, 1, 1));
		builder.nextLine();
		builder.append("Quantidade:");
		builder.add(textFieldQuantidade, CC.xywh(3, 9, 1, 1));
		builder.nextLine();
		builder.append(fecharBotao);
		builder.add(editarBotao, CC.xy(5, 1));
		builder.add(salvarBotao, CC.xy(5, 13));

		add(builder.getPanel(), BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvarBotao) {

			DAOFactory.getVendaDAO().save(model.getBean());

			dispose();
			
			historicoTable.atualizaLista();

		}

		if (e.getSource() == editarBotao) {
			textFieldIdProduto.setEditable(true);
			textFieldQuantidade.setEditable(true);
			textFieldIdCliente.setEditable(true);

		}
	}

	private JTextField getTextFieldId() {
		return textFieldId;
	}

	private JTextField getTextFieldIdProduto() {
		return textFieldIdProduto;
	}

	private JTextField getTextFieldNomeProduto() {
		return textFieldNomeProduto;
	}

	private JTextField getTextFieldQuantidade() {
		return textFieldQuantidade;
	}

	private JTextField getTextFieldIdCliente() {
		return textFieldIdCliente;
	}
}