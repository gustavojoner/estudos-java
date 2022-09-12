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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme;
import com.projeto.ui.util.Icones;
import com.projeto.ui.util.OpenPanel;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel(new BorderLayout());
	JMenuBar menu = new JMenuBar();

	JMenu menuArquivo = new JMenu("Arquivo");
	JMenu menuTemas = new JMenu("Temas");
	JMenu menuVendas = new JMenu(new OpenPanel(panel, () -> new VendaInicioPanel()));
	JMenuItem menuNovaVenda = new JMenuItem(new OpenPanel(panel, () -> new VendaInicioPanel()));
	JMenuItem menuHistoricoVendas = new JMenuItem(new OpenPanel(panel, () -> new HistoricoInicioPanel()));
	JMenuItem menuEstoque = new JMenuItem(new OpenPanel(panel, () -> new ProdutoInicioPanel()));
	JMenuItem menuClientes = new JMenuItem(new OpenPanel(panel, () -> new ClienteInicioPanel()));
	JMenuItem menuTemaDark = new JMenuItem("Dark");
	JMenuItem menuTemaLight = new JMenuItem("Light");
	JMenuItem menuLogout = new JMenuItem("Logout");
	JMenuItem menuSair = new JMenuItem("Sair");

	Icones icon = new Icones();

	public MainFrame() {

		setTitle("System Gustavo");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setJMenuBar(menu);
		setUndecorated(true); // TIRA BORDA
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {

		menuVendas.setText("Vendas");
		menuVendas.setIcon(icon.getShopIcon());
		menuVendas.addActionListener(this);
		menuNovaVenda.setText("Nova Venda");
		menuHistoricoVendas.setText("Histórico");

		menuClientes.setText("Clientes");
		menuEstoque.setText("Estoque");
		menuEstoque.addActionListener(this);

		menuTemaDark.addActionListener(this);
		menuTemaDark.setIcon(icon.getDarkIcon());
		menuTemaLight.addActionListener(this);
		menuTemaLight.setIcon(icon.getLightIcon());

		menuLogout.addActionListener(this);
		menuLogout.setIcon(icon.getLogoutIcon());

		menuSair.addActionListener(e -> System.exit(0));
		menuSair.setIcon(icon.getPowerIcon());
		menu.add(menuArquivo);

		menuArquivo.add(menuVendas);
		menuArquivo.add(menuClientes);
		menuArquivo.add(menuEstoque);
		menuArquivo.add(new JSeparator());
		menuArquivo.add(menuTemas);
		menuArquivo.add(menuLogout);
		menuArquivo.add(menuSair);

		menuVendas.add(menuNovaVenda);
		menuVendas.add(menuHistoricoVendas);

		menuTemas.add(menuTemaDark);
		menuTemas.add(menuTemaLight);

		add(panel, BorderLayout.CENTER);
	}

	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		if (action.getSource() == menuEstoque) {
			new ProdutoInicioPanel();
			revalidate();
		}

		else if (action.getSource() == menuVendas) {
			new VendaInicioPanel();
			revalidate();
		}

		else if (action.getSource() == menuLogout) {
			new LoginFrame();
			dispose();
		}

		else if (action.getSource() == menuTemaDark) {
			try {
				UIManager.setLookAndFeel(new FlatDarculaLaf());
				SwingUtilities.updateComponentTreeUI(this);
				
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}

		} else if (action.getSource() == menuTemaLight) {
			try {
				UIManager.setLookAndFeel(new FlatGrayIJTheme());
				SwingUtilities.updateComponentTreeUI(this);
				
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		}
	}

}
