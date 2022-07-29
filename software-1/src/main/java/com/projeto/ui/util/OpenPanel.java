package com.projeto.ui.util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.function.Supplier;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OpenPanel extends AbstractAction {

	private JPanel main;
	private JPanel panel;
	private Supplier<JPanel> panelSupplier;

	public OpenPanel(JPanel main, JPanel panel) {
		this.main = main;
		this.panel = panel;
	}
	
	public OpenPanel(JPanel main, Supplier<JPanel> panelSupplier) {
		this.main = main;
		this.panelSupplier = panelSupplier;
	}

	public void actionPerformed(ActionEvent e) {
		main.removeAll();
		if (panelSupplier != null) {
			main.add(panelSupplier.get(), BorderLayout.CENTER);
		} else {
			main.add(panel, BorderLayout.CENTER);
		}
		main.revalidate();
		main.repaint();
	}
}