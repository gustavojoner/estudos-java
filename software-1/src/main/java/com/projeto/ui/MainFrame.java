package com.projeto.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.projeto.ui.util.OpenPanel;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel(new BorderLayout());
	JMenuBar menu = new JMenuBar();
	JMenu menuArquivo = new JMenu("Arquivo");

	JMenu menuVendas = new JMenu(new OpenPanel(panel, () -> new VendaInicioPanel()));
	JMenuItem menuNovaVenda = new JMenuItem(new OpenPanel(panel, () -> new VendaInicioPanel()));
	JMenuItem menuHistoricoVendas = new JMenuItem(new OpenPanel(panel, () -> new HistoricoInicioPanel()));
	JMenuItem menuEstoque = new JMenuItem(new OpenPanel(panel, () -> new ProdutoInicioPanel()));
	JMenuItem menuClientes = new JMenuItem(new OpenPanel(panel, () -> new ClienteInicioPanel()));

	JMenuItem menuLogout = new JMenuItem("Logout");
	JMenuItem menuSair = new JMenuItem("Sair");

	public MainFrame() {

		setTitle("System Gustavo");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setJMenuBar(menu);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		menu.add(menuArquivo);

		menuArquivo.add(menuVendas);
		menuVendas.setText("Vendas");
		menuVendas.addActionListener(this);

		menuVendas.add(menuNovaVenda);
		menuNovaVenda.setText("Nova Venda");

		menuVendas.add(menuHistoricoVendas);
		menuHistoricoVendas.setText("Histórico");

		menuArquivo.add(menuClientes);
		menuClientes.setText("Clientes");

		menuArquivo.add(menuEstoque);
		menuEstoque.setText("Estoque");
		menuEstoque.addActionListener(this);

		menuArquivo.add(new JSeparator());

		menuArquivo.add(menuLogout);
		menuLogout.addActionListener(this);

		menuArquivo.add(menuSair);
		menuSair.addActionListener(e -> System.exit(0));

		add(panel, BorderLayout.CENTER);
	}

	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuEstoque) {
			new ProdutoInicioPanel();
			revalidate();
		}

		else if (e.getSource() == menuVendas) {
			new VendaInicioPanel();
			revalidate();
		}

		else if (e.getSource() == menuLogout) {
			new LoginFrame();
			dispose();
		}
	}

}
