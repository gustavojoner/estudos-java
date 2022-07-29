package com.projeto.ui.tables;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import com.projeto.dao.DAOFactory;
import com.projeto.domain.Venda;

public class VendaTable {

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private SelectionInList<Venda> listVendas = new SelectionInList<>();
	
	public VendaTable() {

		table = new JTable(new VendaTableModel(listVendas));
		scrollPane = new JScrollPane(table);

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		table.setBorder(border);

		scrollPane.setPreferredSize(new Dimension(850, 310));

		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null); // BLOQUEAR EDICAO DE CELULAS

		table.getColumnModel().getColumn(0).setPreferredWidth(20); // LARGURA DA COLUNA
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);

		table.getTableHeader().setReorderingAllowed(false);

		Bindings.bind(table, listVendas);
	}

	public void deletaLinha() {
		VendaTableModel model = (VendaTableModel) table.getModel();
		model.removeVenda(table.getSelectedRows());
	}

	public void addLinha(Venda venda) {
		VendaTableModel model = (VendaTableModel) table.getModel();
		model.addVenda(venda);
	}

	public JTable getTable() {
		return table;
	}
	public void removeAll() {
		listVendas.getList().clear();
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
	
	public List<Venda> getVendas() {
		return Collections.unmodifiableList(listVendas.getList());
	}

	@SuppressWarnings("serial")
	static class VendaTableModel extends AbstractTableAdapter<Venda> {

		private SelectionInList<Venda> listVendas;

		public VendaTableModel(SelectionInList<Venda> listVendas) {
			super(listVendas);
			this.listVendas = listVendas;
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "ID Produto";
			case 1:
				return "Produto";
			case 2:
				return "Quantidade";
			}
			return super.getColumnName(column);
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Venda venda = getRow(rowIndex);
			switch (columnIndex) {
			
			case 0:
				return venda.getProduto().getIdProduto();
			case 1:
				return venda.getProduto().getNomeProduto();			
			case 2:
				return venda.getQuantidadeVenda();
			}
			return null;
		}

		public void removeVenda(int... index) {
			int min = Integer.MAX_VALUE;
			int max = -1;
			int removed = 0;
			for (int i : index) {
				min = Math.min(min, i);
				max = Math.max(max, i);
				Venda venda = this.listVendas.getList().remove(i - removed++);
				DAOFactory.getVendaDAO().delete(venda);
			}
			fireTableRowsDeleted(min, max);
		}

		public void addVenda(Venda v) {
			this.listVendas.getList().add(v);
			listVendas.setSelection(v);
		}

		public Venda getVenda() {
			return listVendas.getSelection();
		}
	}
}