package com.projeto.view.aparelho;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import com.projeto.model.model.Aparelho;
import com.projeto.model.service.AparelhoService;
import com.projeto.util.ProcessamentoDeDados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AparelhoFrame extends JFrame {

	
	private static final long serialVersionUID = 4481782682195564078L;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldIdCliente;
	private JTextField textFieldMarca;
	
	AparelhoService aparelhoService;
	private Aparelho aparelho;
	private JTextField textFieldNumSerie;
	
	private JButton btnFechar;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnBuscar;
	
	public AparelhoFrame() {
		
		aparelhoService = new AparelhoService();
		aparelho = new Aparelho();
		
		initComponents();
		createEvents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 503);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(26, 28, 748, 310);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(81, 38, 46, 14);
		panel.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(232, 35, 129, 20);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 80, 46, 14);
		panel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(232, 77, 256, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(81, 123, 83, 14);
		panel.add(lblIdCliente);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setBounds(232, 120, 256, 20);
		panel.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(81, 160, 46, 14);
		panel.add(lblMarca);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(232, 157, 256, 20);
		panel.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel lblNumSerie = new JLabel("Num S\u00E9rie");
		lblNumSerie.setBounds(82, 199, 82, 14);
		panel.add(lblNumSerie);
		
		textFieldNumSerie = new JTextField();
		textFieldNumSerie.setBounds(232, 197, 256, 20);
		panel.add(textFieldNumSerie);
		textFieldNumSerie.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(26, 391, 748, 48);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnNovo = new JButton("Incluir");
		btnNovo.setToolTipText("Incluir dados do Cliente");
		btnNovo.setIcon(new ImageIcon(AparelhoFrame.class.getResource("/imagens/book_add.png")));
		btnNovo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNovo.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 11));
		btnNovo.setBounds(23, 11, 89, 23);
		panel_1.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("Alterar dados do usu\u00E1rio\r\n");
		btnAlterar.setIcon(new ImageIcon(AparelhoFrame.class.getResource("/imagens/book_edit.png")));
		btnAlterar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAlterar.setBounds(243, 11, 89, 23);
		panel_1.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("Excluir dados do usu\u00E1rio");
		btnExcluir.setIcon(new ImageIcon(AparelhoFrame.class.getResource("/imagens/book_delete.png")));
		btnExcluir.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnExcluir.setBounds(352, 11, 89, 23);
		panel_1.add(btnExcluir);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnFechar.setBounds(465, 11, 89, 23);
		panel_1.add(btnFechar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(AparelhoFrame.class.getResource("/imagens/book_go.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuscar.setBounds(135, 12, 85, 21);
		panel_1.add(btnBuscar);
		
	}
	

	private void createEvents() {
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDigitacao() == ProcessamentoDeDados.FALSO) {
					setDadosAparelhoFromView();
					incluirAparelho();
				}
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDigitacao() == ProcessamentoDeDados.FALSO) {
					setDadosAparelhoFromView();
					alterarAparelho();
				}
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDigitacao() == ProcessamentoDeDados.FALSO) {
					setDadosAparelhoFromView();
					excluirAparelho();
				}
			}
		});
		
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private boolean verificarDigitacao() {
		if(ProcessamentoDeDados.digitacaoCampo(textFieldNome.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação do nome do aparelho", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldNome.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(textFieldNome.getText().length() > 80) {
			JOptionPane.showMessageDialog(null, "Erro na digitação do nome do aparelho", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldNome.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldIdCliente.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação do id do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldIdCliente.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(textFieldIdCliente.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "Erro na digitação do id do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldIdCliente.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO; 
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldNumSerie.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação do Numero de Série do aparelho", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldNumSerie.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldMarca.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação da marca do aparelho", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldMarca.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		
		return ProcessamentoDeDados.FALSO;
	}
	
	private void limparCampos() {
		textFieldNome.setText("");
		textFieldIdCliente.setText("");
		textFieldNumSerie.setText("");
		textFieldMarca.setText("");
		textFieldCodigo.requestFocus();
	}
	
	private void setDadosAparelhoFromView() {
		aparelho.setNome(textFieldNome.getText());
		aparelho.setIdCliente(Integer.parseInt(textFieldIdCliente.getText()));
		aparelho.setNumeroSerie(textFieldNumSerie.getText());
		aparelho.setMarca(textFieldMarca.getText());
	}
	
	public void incluirAparelho() {
		aparelhoService.save(aparelho);
		limparCampos();
	}
	
	public void alterarAparelho() {
		aparelhoService.update(aparelho);
		limparCampos();
	}
	
	private void buscarCliente() {
	
		Integer id = 0; 
		
		if(!textFieldCodigo.getText().equals("")) {
			
			id = Integer.parseInt(textFieldCodigo.getText());
			aparelho = aparelhoService.findClienteById(id);
			
			textFieldNome.setText(aparelho.getNome());
			textFieldIdCliente.setText(aparelho.getIdCliente().toString());
			textFieldNumSerie.setText(aparelho.getNumeroSerie());
			textFieldMarca.setText(aparelho.getMarca());
		}
	}
	
	private void excluirAparelho() {
		aparelhoService.delete(aparelho);
		limparCampos();
	}
}
