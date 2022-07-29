package com.projeto.ui.tables;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;

import com.projeto.dao.DAOFactory;
import com.projeto.domain.Cliente;
import com.projeto.ui.ClienteVisualizaFrame;

public class ClienteTable {

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private SelectionInList<Cliente> listClientes = new SelectionInList<>();

	public ClienteTable() {

		table = new JTable(new ClienteTableModel(listClientes));
		scrollPane = new JScrollPane(table);

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		table.setBorder(border);

		scrollPane.setPreferredSize(new Dimension(850, 310));

		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null); // BLOQUEAR EDICAO DE CELULAS

		table.getColumnModel().getColumn(0).setPreferredWidth(5); // LARGURA DA COLUNA
		table.getColumnModel().getColumn(1).setPreferredWidth(500);

		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer); // CENTRALIZA TEXTO EM CELULA
		table.getTableHeader().setReorderingAllowed(false);

		Bindings.bind(table, listClientes);
	}
	
	public void atualizaLista() {
		ClienteTableModel model = (ClienteTableModel) table.getModel();
		List<Cliente> listaCliente = DAOFactory.getClienteDAO().listAll();
		listClientes.getList().clear();
		model.fireTableDataChanged();
		for (Cliente cliente : listaCliente) {
			model.addCliente(cliente);
		}
	}

	public void abrirLinha() {
		new ClienteVisualizaFrame(listClientes.getSelection(), this);
	}

	public void deletaLinha() {
		ClienteTableModel model = (ClienteTableModel) table.getModel();
		model.removeCliente(table.getSelectedRows());
	}

	public JTable getTable() {
		return table;
	}

	public void removeAll() {
		table.removeAll();
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public DefaultTableCellRenderer getCellRenderer() {
		return cellRenderer;
	}

	public void setCellRenderer(DefaultTableCellRenderer cellRenderer) {
		this.cellRenderer = cellRenderer;

	}

	@SuppressWarnings("serial")
	static class ClienteTableModel extends AbstractTableAdapter<Cliente> {

		private SelectionInList<Cliente> listClientes;

		public ClienteTableModel(SelectionInList<Cliente> listClientes) {
			super(listClientes);
			this.listClientes = listClientes;
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "ID Nome";
			case 1:
				return "Nome";
			}
			return super.getColumnName(column);
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Cliente cliente = getRow(rowIndex);
			switch (columnIndex) {

			case 0:
				return cliente.getIdCliente();
			case 1:
				return cliente.getNomeCliente();

			}
			return null;
		}

		public void removeCliente(int... index) {
			int min = Integer.MAX_VALUE;
			int max = -1;
			int removed = 0;
			for (int i : index) {
				min = Math.min(min, i);
				max = Math.max(max, i);
				Cliente cliente = this.listClientes.getList().remove(i - removed++);
				DAOFactory.getClienteDAO().delete(cliente);
				
			}
			fireTableRowsDeleted(min, max);
		}

		public void addCliente(Cliente c) {
			this.listClientes.getList().add(c);
			listClientes.setSelection(c);
		}

		public Cliente getCliente() {
			return listClientes.getSelection();
		}
	}

}
