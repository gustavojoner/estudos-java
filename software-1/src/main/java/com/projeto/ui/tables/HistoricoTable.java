package com.projeto.ui.tables;

import java.awt.Color;
import java.awt.Dimension;
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
import com.projeto.ui.HistoricoVisualizaVendaFrame;

public class HistoricoTable {

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private SelectionInList<Venda> listVendas = new SelectionInList<>();

	
	public HistoricoTable() {

		table = new JTable(new VendaTableModel(listVendas));
		scrollPane = new JScrollPane(table);

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		table.setBorder(border);

		scrollPane.setPreferredSize(new Dimension(850, 310));

		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null); // BLOQUEAR EDICAO DE CELULAS

		table.getColumnModel().getColumn(0).setPreferredWidth(20); // LARGURA DA COLUNA
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);

		table.getTableHeader().setReorderingAllowed(false);

		Bindings.bind(table, listVendas);
	}

	public void deletaLinha() {
		VendaTableModel model = (VendaTableModel) table.getModel();
		model.removeVenda(table.getSelectedRows());
	}
	
	public void atualizaLista() {
		VendaTableModel model = (VendaTableModel) table.getModel();
		List<Venda> listaVenda = DAOFactory.getVendaDAO().listAll();
		listVendas.getList().clear();
		model.fireTableDataChanged();
		for (Venda venda : listaVenda) {
			model.addVenda(venda);
		}
	}
	
	public void abrirLinha() {
		new HistoricoVisualizaVendaFrame(listVendas.getSelection(), this);
	}

	public void addLinha(Venda venda) {
		VendaTableModel model = (VendaTableModel) table.getModel();
		model.addVenda(venda);
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
				return "ID Venda";
			case 1:
				return "ID Produto";
			case 2:
				return "Produto";
			case 3:
				return "ID Cliente";
			case 4:
				return "Quantidade";
			}
			return super.getColumnName(column);
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Venda venda = getRow(rowIndex);
			switch (columnIndex) {
			
			case 0:
				return venda.getIdVenda();
			case 1:
				return venda.getProduto().getIdProduto();
			case 2:
				return venda.getProduto().getNomeProduto();			
			case 3:
				return venda.getCliente().getIdCliente();
			case 4:
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