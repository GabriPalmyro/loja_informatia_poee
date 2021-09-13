package com.projeto.view.cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.border.LineBorder;

import com.projeto.model.model.Cliente;
import com.projeto.model.service.ClienteService;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TabelaCliente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2245445345139329072L;
	
	private static final int CODIGO 	= 0;
	private static final int CPF 		= 1;
	private static final int NOME 		= 2;
	private static final int CEP 		= 3;
	private static final int BAIRRO 	= 4;
	private static final int CIDADE		= 5;
	private static final int RUA 		= 6;
	private static final int TELEFONE 	= 7;
	
	private JTextField textFieldBuscaNome;
	private JComboBox comboBoxRegistrosTabela;
	private TabelaClienteModel tabelaClienteModel;
	private JTable tabelaCliente;
	private JScrollPane scrollPane;
	
	//botoes
	private JButton btnPrimeiro;
	private JButton btnProximo;
	
	private ClienteService clienteService;
	
	private Integer totalRegistros = 0;
	private Integer registrosPorPagina = 5;
	private Integer totalPaginas = 1;
	private Integer paginaAtual = 1;
	
	public TabelaCliente() {
		setBounds(new Rectangle(100, 100, 1050, 650));
		
	
		initComponents();
		iniciarPaginacao();
		createEvents();
	}

	private void createEvents() {
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paginaAtual = 1;
				iniciarPaginacao();
			}
		});
		
	}

	private void iniciarPaginacao() {
		
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		totalRegistros = buscarTotalRegistrosClientes();
		registrosPorPagina = Integer.valueOf( comboBoxRegistrosTabela.getSelectedItem().toString() );
		
		Double totalPaginasTabela = Math.ceil( totalRegistros.doubleValue() / registrosPorPagina.doubleValue() );
		
		totalPaginas = totalPaginasTabela.intValue();
	
		if(paginaAtual.equals(1)) {
			btnPrimeiro.setEnabled(false);
			btnProximo.setEnabled(false);
		} else {
			btnPrimeiro.setEnabled(true);
			btnProximo.setEnabled(true);
		}
		
		listaCliente = carregarListaCliente(paginaAtual, registrosPorPagina);
		
		tabelaClienteModel.setListaCliente(listaCliente);
		tabelaCliente.setModel(tabelaClienteModel);
		tabelaClienteModel.fireTableDataChanged();
		
		tabelaCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaCliente.getColumnModel().getColumn(CODIGO).setPreferredWidth(11);
		tabelaCliente.getColumnModel().getColumn(NOME).setPreferredWidth(100);
		tabelaCliente.getColumnModel().getColumn(CPF).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(CEP).setPreferredWidth(20);
		tabelaCliente.getColumnModel().getColumn(BAIRRO).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(CIDADE).setPreferredWidth(50);
		tabelaCliente.getColumnModel().getColumn(RUA).setPreferredWidth(100);
		tabelaCliente.getColumnModel().getColumn(TELEFONE).setPreferredWidth(20);
	
		//scrollPane.setViewportView(tabelaCliente);
		
	}

	private List<Cliente> carregarListaCliente(Integer paginaAtual, Integer registrosPorPagina) {
		
		ClienteService clienteService = new ClienteService();
		return clienteService.carregarListaCliente(paginaAtual, registrosPorPagina);
	}

	private Integer buscarTotalRegistrosClientes() {
		return clienteService.countTotalRegistroClientes();
	}

	private void initComponents() {
		
		clienteService = new ClienteService();
		tabelaClienteModel = new TabelaClienteModel();
		
		getContentPane().setLayout(null);
		
		JPanel tabelaView = new JPanel();
		tabelaView.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabelaView.setBackground(Color.WHITE);
		tabelaView.setBounds(63, 39, 926, 425);
		getContentPane().add(tabelaView);
		tabelaView.setLayout(null);
		
		tabelaCliente = new JTable();
		tabelaCliente.setBounds(12, 13, 902, 399);
		tabelaView.add(tabelaCliente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 902, 399);
		tabelaView.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(63, 477, 605, 56);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrimeiro.setBounds(39, 13, 92, 32);
		panel_1.add(btnPrimeiro);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnterior.setBounds(178, 14, 92, 31);
		panel_1.add(btnAnterior);
		
		btnProximo = new JButton("Proximo");
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnProximo.setBounds(316, 14, 99, 31);
		panel_1.add(btnProximo);
		
		JButton btnUltimo = new JButton("Ultimo");
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUltimo.setBounds(454, 14, 99, 30);
		panel_1.add(btnUltimo);
		
		JLabel lblPaginaLabel = new JLabel("Pagina atual: ");
		lblPaginaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaginaLabel.setBounds(859, 477, 73, 24);
		getContentPane().add(lblPaginaLabel);
		
		JLabel lblPaginaNumber = new JLabel(paginaAtual.toString());
		lblPaginaNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaginaNumber.setBounds(961, 477, 20, 24);
		getContentPane().add(lblPaginaNumber);
		
		comboBoxRegistrosTabela = new JComboBox();
		comboBoxRegistrosTabela.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "50"}));
		comboBoxRegistrosTabela.setBounds(929, 10, 47, 21);
		getContentPane().add(comboBoxRegistrosTabela);
		
		JLabel lblNewLabel = new JLabel("Quantidade de registros por p\u00E1gina");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(717, 10, 202, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTotalDePginas = new JLabel("Total de paginas:\r\n");
		lblTotalDePginas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalDePginas.setBounds(835, 511, 114, 24);
		getContentPane().add(lblTotalDePginas);
		
		JLabel lblPaginaNumber_1 = new JLabel(totalPaginas.toString());
		lblPaginaNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaginaNumber_1.setBounds(961, 511, 20, 24);
		getContentPane().add(lblPaginaNumber_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(63, 546, 740, 56);
		getContentPane().add(panel_2);
		
		JButton btnInclusao = new JButton("Inclus\u00E3o");
		btnInclusao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInclusao.setBounds(39, 13, 92, 32);
		panel_2.add(btnInclusao);
		
		JButton btnAlteracao = new JButton("Altera\u00E7\u00E3o");
		btnAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlteracao.setBounds(178, 14, 92, 31);
		panel_2.add(btnAlteracao);
		
		JButton btnExclusao = new JButton("Exclus\u00E3o");
		btnExclusao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExclusao.setBounds(316, 14, 99, 31);
		panel_2.add(btnExclusao);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsulta.setBounds(454, 14, 99, 30);
		panel_2.add(btnConsulta);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFechar.setBounds(591, 13, 99, 30);
		panel_2.add(btnFechar);
		
		JLabel lblBusca = new JLabel("Busca por Nome");
		lblBusca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBusca.setBounds(64, 10, 93, 21);
		getContentPane().add(lblBusca);
		
		textFieldBuscaNome = new JTextField();
		textFieldBuscaNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldBuscaNome.setBounds(167, 11, 223, 21);
		getContentPane().add(textFieldBuscaNome);
		textFieldBuscaNome.setColumns(10);
	}
}
