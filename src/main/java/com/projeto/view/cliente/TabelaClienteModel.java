package com.projeto.view.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import com.projeto.model.model.Cliente;


public class TabelaClienteModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -6240691195689788290L;

	private final String colunas[] = {
			"Código",
			"CPF",
			"Nome",
			"CEP",
			"Bairro",
			"Cidade",
			"Rua",
			"Telefone"
	};
	
	private static final int CODIGO 	= 0;
	private static final int CPF 		= 1;
	private static final int NOME 		= 2;
	private static final int CEP 		= 3;
	private static final int BAIRRO 	= 4;
	private static final int CIDADE		= 5;
	private static final int RUA 		= 6;
	private static final int TELEFONE 	= 7;
	
	private List<Cliente> listaCliente;
	
	public TabelaClienteModel() {
		listaCliente = new ArrayList<Cliente>();
	}

	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public Cliente getCliente(int index) {
		return getListaCliente().get(index);
	}
	
	public void saveCliente( Cliente cliente ) {
		getListaCliente().add(cliente);
		fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
	}
	
	public void updateCliente( Cliente cliente, int index ) {
		getListaCliente().set(index, cliente);
		fireTableRowsUpdated(index, index);
	}
	
	public void removeCliente(int index ) {
		getListaCliente().remove(index);
		fireTableRowsDeleted(index, index);
	}
	
	public void removeAll() {
		getListaCliente().clear();
		fireTableDataChanged();
	}
	
	public String getNomeColuna(int index) {
		 return getColunas()[index];
	}

	@Override
	public int getRowCount() {
		getListaCliente().size();
		return 0;
	}

	@Override
	public int getColumnCount() {
		return getColunas().length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Cliente cliente = getListaCliente().get(rowIndex);
		
		switch(columnIndex) {
			case CODIGO:
				return cliente.getId();
			case CPF:
				return cliente.getCpf();
			case NOME:
				return cliente.getNome();
			case CEP:
				return cliente.getCep();
			case BAIRRO:
				return cliente.getBairro();
			case CIDADE:
				return cliente.getCidade();
			case RUA:
				return cliente.getRua();
			case TELEFONE:
				return cliente.getTelefone();
			default:
				return cliente;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(getListaCliente().isEmpty()) {
			return Object.class;
		}
		
		return getValueAt(0, columnIndex).getClass();
	}
	
	public String[] getColunas() {
		return colunas;
	}

}
