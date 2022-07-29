package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.projeto.ui.tables.ClienteTable;
import com.projeto.ui.util.OpenPanel;

public class ClienteInicioPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	JButton criarBotao = new JButton(new OpenPanel(this, new ClienteNovoPanel()));
	JButton abrirBotao = new JButton();
	JButton deletarBotao = new JButton();
	JButton voltarBotao = new JButton();
	ClienteTable tablePanel = new ClienteTable();

	public ClienteInicioPanel() {
		setLayout(new BorderLayout());
		initComponents();
		initLayout();
		tablePanel.atualizaLista();
	}

	private void initComponents() {

		criarBotao.setText("Criar");

		abrirBotao.setText("Abrir");
		abrirBotao.addActionListener(e -> tablePanel.abrirLinha());

		deletarBotao.setText("Deletar");
		deletarBotao.addActionListener(e -> tablePanel.deletaLinha());

		voltarBotao.setText("Voltar");
		voltarBotao.addActionListener(e -> {
			this.removeAll();
			this.repaint();
		});

		tablePanel.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {

				if (e.getClickCount() == 2) {
					tablePanel.abrirLinha();
				}

			};
		});
	}

	public void initLayout() {

		FormLayout layout = new FormLayout("60dlu, 10px, 360dlu:grow");
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);

		builder.border(new EmptyBorder(10, 10, 10, 10));

		builder.append(criarBotao);
		builder.nextLine();
		builder.append(abrirBotao);
		builder.nextLine();
		builder.append(deletarBotao);
		builder.nextLine();
		builder.appendRow("235dlu:grow");
		builder.nextLine();
		builder.append(voltarBotao);

		builder.add(tablePanel.getScrollPane(), CC.xywh(3, 1, 1, 8));

		add(builder.getPanel());
	}
}
