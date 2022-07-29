package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.SpinnerToValueModelConnector;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.projeto.dao.DAOFactory;
import com.projeto.domain.Cliente;
import com.projeto.domain.Produto;
import com.projeto.domain.Venda;
import com.projeto.domain.command.EfetuaFinalizacaoCarrinhoCommand;
import com.projeto.ui.tables.VendaTable;

public class VendaInicioPanel extends JPanel implements ActionListener {

	JPanel panel = new JPanel();

	JButton adicionaBotao;
	JButton editarBotao;
	JButton removeBotao;
	JButton finalizaBotao;
	JButton voltarBotao;
	JSpinner quantidadeSpinner;

	JComboBox<List<Produto>> produtoBox;
	JComboBox<List<Cliente>> clienteBox;

	VendaTable tablePanel = new VendaTable();

	PresentationModel<Venda> model;

	public VendaInicioPanel() {
		panel.setLayout(new BorderLayout());
		initModels();
		initComponents();
		initLayout();
	}

	private void initModels() {

		model = new PresentationModel<Venda>();
		model.setBean(new Venda());

	}

	private void initComponents() {

		panel = new JPanel();

		adicionaBotao = new JButton();
		adicionaBotao.setText("Adicionar");
		adicionaBotao.addActionListener(this);

		editarBotao = new JButton();
		editarBotao.setText("Editar");
		editarBotao.addActionListener(this);

		removeBotao = new JButton();
		removeBotao.setText("Remover");
		removeBotao.addActionListener(e -> tablePanel.deletaLinha());

		finalizaBotao = new JButton();
		finalizaBotao.setText("Finalizar");
		finalizaBotao.addActionListener(this);

		voltarBotao = new JButton();
		voltarBotao.setText("Voltar");
		voltarBotao.addActionListener(e -> {
			this.removeAll();
			this.repaint();
		});

		produtoBox = BasicComponentFactory
				.createComboBox(new SelectionInList<>(DAOFactory.getProdutoDAO().listAll(), model.getModel("produto")));
		clienteBox = BasicComponentFactory
				.createComboBox(new SelectionInList<>(DAOFactory.getClienteDAO().listAll(), model.getModel("cliente")));

		SpinnerNumberModel spinnerModel = new SpinnerNumberModel();
		quantidadeSpinner = new JSpinner(spinnerModel);
		SpinnerToValueModelConnector.connect(spinnerModel, model.getModel("quantidadeVenda"), 0d);

	}

	public void initLayout() {

		FormLayout layout = new FormLayout("60dlu, 10px, 60dlu, 10px, fill:265dlu:grow, 10px, 60dlu");
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);

		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.append("Cliente:");
		builder.add(clienteBox, CC.xywh(3, 1, 3, 1));
		builder.add(removeBotao, CC.xy(7, 1));
		builder.nextLine();
		builder.append("Produto:");
		builder.add(produtoBox, CC.xywh(3, 3, 3, 1));
		builder.add(editarBotao, CC.xy(7, 3));
		builder.nextLine();
		builder.append("Quantidade:");
		builder.add(quantidadeSpinner, CC.xywh(3, 5, 3, 1));
		builder.add(adicionaBotao, CC.xy(7, 5));
		builder.nextLine();
		builder.appendRow("3dlu");
		builder.nextLine();
		builder.appendRow("245dlu:grow");
		builder.append(tablePanel.getScrollPane(), 7);
		builder.nextLine();
		builder.append(voltarBotao);
		builder.add(finalizaBotao, CC.xywh(7, 9, 1, 1));

		add(builder.getPanel());

	}

	public int getValueSpinner() {
		return (int) quantidadeSpinner.getValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adicionaBotao) {

			if (model.getBean().isDisponivel() == true) {
				Venda venda = model.getBean();
				tablePanel.addLinha(venda);
				model.setBean(new Venda());
				
			} else {
				JOptionPane.showMessageDialog(null, " Estoque Insuficiente");
			}
		}

		if (e.getSource() == finalizaBotao) {
			try {
				new EfetuaFinalizacaoCarrinhoCommand(tablePanel.getVendas()).execute();
				model.setBean(new Venda());
				tablePanel.removeAll();
				JOptionPane.showMessageDialog(null, "  Salvo com sucesso!");
				
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
	}
}
