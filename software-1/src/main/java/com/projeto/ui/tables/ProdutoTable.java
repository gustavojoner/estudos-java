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
import com.projeto.domain.Produto;
import com.projeto.ui.ProdutoVisualizaFrame;

public class ProdutoTable {

	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private SelectionInList<Produto> listProdutos = new SelectionInList<>();
	
	public ProdutoTable() {

		table = new JTable(new ProdutoTableModel(listProdutos));
		scrollPane = new JScrollPane(table);

		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		table.setBorder(border);

		scrollPane.setPreferredSize(new Dimension(850, 310));

		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null); // BLOQUEAR EDICAO DE CELULAS

		table.getColumnModel().getColumn(0).setPreferredWidth(20); // LARGURA DA COLUNA
		table.getColumnModel().getColumn(1).setPreferredWidth(400);

		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer); // CENTRALIZA TEXTO EM CELULA
		table.getTableHeader().setReorderingAllowed(false);

		Bindings.bind(table, listProdutos);
	}

	public void atualizaLista() {
		ProdutoTableModel model = (ProdutoTableModel) table.getModel();
		List<Produto> listaProduto = DAOFactory.getProdutoDAO().listAll();
		listProdutos.getList().clear();
		model.fireTableDataChanged();
		for (Produto produto : listaProduto) {
			model.addProduto(produto);
		}
	}

	public void abrirLinha() {
		new ProdutoVisualizaFrame(listProdutos.getSelection(), this);
	}

	public void deletaLinha() {
		ProdutoTableModel model = (ProdutoTableModel) table.getModel();		
		model.removeProduto(table.getSelectedRows());
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
	static class ProdutoTableModel extends AbstractTableAdapter<Produto> {

		private SelectionInList<Produto> listProdutos;

		public ProdutoTableModel(SelectionInList<Produto> listProdutos) {
			super(listProdutos);
			this.listProdutos = listProdutos;
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "ID Produto";
			case 1:
				return "Item";
			case 2:
				return "Valor";
			case 3:
				return "Quantidade";
			}
			return super.getColumnName(column);
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Produto produto = getRow(rowIndex);
			switch (columnIndex) {

			case 0:
				return produto.getIdProduto();
			case 1:
				return produto.getNomeProduto();
			case 2:
				return produto.getValorProduto();
			case 3:
				return produto.getQuantidadeItem();
			}
			return null;
		}

		public void removeProduto(int... index) {
			int min = Integer.MAX_VALUE;
			int max = -1;
			int removed = 0;
			for (int i : index) {
				min = Math.min(min, i);
				max = Math.max(max, i);
				Produto produto = this.listProdutos.getList().remove(i - removed++);
				DAOFactory.getProdutoDAO().delete(produto);
			}
			fireTableRowsDeleted(min, max);
		}

		public void addProduto(Produto p) {
			this.listProdutos.getList().add(p);
			listProdutos.setSelection(p);
		}

		public Produto getProduto() {
			return listProdutos.getSelection();
		}
	}

}
