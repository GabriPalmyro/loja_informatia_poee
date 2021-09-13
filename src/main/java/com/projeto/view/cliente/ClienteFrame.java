package com.projeto.view.cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import com.projeto.model.model.Cliente;
import com.projeto.model.service.ClienteService;
import com.projeto.util.ProcessamentoDeDados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
public class ClienteFrame extends JFrame {

	
	private static final long serialVersionUID = 4481782682195564078L;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldCidade;
	
	ClienteService clienteService;
	private Cliente cliente;
	private JTextField textFieldCEP;
	
	private JButton btnFechar;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldTelefone;
	
	public ClienteFrame() {
		
		clienteService = new ClienteService();
		cliente = new Cliente();
		
		initComponents();
		createEvents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 517);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(26, 28, 748, 327);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(81, 38, 46, 14);
		panel.add(lblCodigo);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(156, 35, 129, 20);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 80, 46, 14);
		panel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(156, 77, 256, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(81, 123, 46, 14);
		panel.add(lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(156, 120, 256, 20);
		panel.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(306, 160, 46, 14);
		panel.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(362, 157, 129, 20);
		panel.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblEndereco = new JLabel("CEP");
		lblEndereco.setBounds(81, 160, 46, 14);
		panel.add(lblEndereco);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setBounds(156, 157, 129, 20);
		panel.add(textFieldCEP);
		textFieldCEP.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(81, 200, 46, 14);
		panel.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(156, 197, 129, 20);
		panel.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(306, 200, 46, 14);
		panel.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(362, 197, 129, 20);
		panel.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(75, 242, 52, 14);
		panel.add(lblTelefone);
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(156, 239, 257, 20);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(26, 384, 748, 48);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnNovo = new JButton("Incluir");
		btnNovo.setToolTipText("Incluir dados do Cliente");
		btnNovo.setIcon(new ImageIcon(ClienteFrame.class.getResource("/imagens/book_add.png")));
		btnNovo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setBounds(23, 11, 89, 23);
		panel_1.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setToolTipText("Alterar dados do usu\u00E1rio\r\n");
		btnAlterar.setIcon(new ImageIcon(ClienteFrame.class.getResource("/imagens/book_edit.png")));
		btnAlterar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnAlterar.setBounds(258, 11, 89, 23);
		panel_1.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setToolTipText("Excluir dados do usu\u00E1rio");
		btnExcluir.setIcon(new ImageIcon(ClienteFrame.class.getResource("/imagens/book_delete.png")));
		btnExcluir.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnExcluir.setBounds(373, 11, 89, 23);
		panel_1.add(btnExcluir);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnFechar.setBounds(485, 11, 89, 23);
		panel_1.add(btnFechar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnBuscar.setIcon(new ImageIcon(ClienteFrame.class.getResource("/imagens/book_go.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		btnBuscar.setBounds(140, 11, 89, 23);
		panel_1.add(btnBuscar);
		
	}
	
	private void createEvents() {
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDigitacao() == ProcessamentoDeDados.FALSO) {
					setDadosClienteFromView();
					incluirCliente();
				}
			}
		});
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDigitacao() == ProcessamentoDeDados.FALSO) {
					setDadosClienteFromView();
					alterarCliente();
				}
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDigitacao() == ProcessamentoDeDados.FALSO) {
					setDadosClienteFromView();
					excluirCliente();
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
			 JOptionPane.showMessageDialog(null, "Erro na digitação do nome do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldNome.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(textFieldNome.getText().length() > 80) {
			JOptionPane.showMessageDialog(null, "Erro na digitação do nome do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldNome.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldCPF.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação do CPF do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldCPF.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(textFieldCPF.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "Erro na digitação do CPF do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldCPF.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO; 
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldCEP.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação do CEP do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldCEP.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldCidade.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação da cidade do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldCidade.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldRua.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação da rua do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldRua.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldBairro.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação do bairro do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldBairro.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		if(ProcessamentoDeDados.digitacaoCampo(textFieldTelefone.getText())) {
			 JOptionPane.showMessageDialog(null, "Erro na digitação do telefone do cliente", "Erro de digitação", JOptionPane.ERROR_MESSAGE);
			 textFieldTelefone.requestFocus();
			 return ProcessamentoDeDados.VERDADEIRO;
		}
		
		return ProcessamentoDeDados.FALSO;
	}
	
	private void limparCampos() {
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldCidade.setText("");
		textFieldCEP.setText("");
		textFieldRua.setText("");
		textFieldBairro.setText("");
		textFieldTelefone.setText("");
		textFieldId.requestFocus();
	}
	
	private void setDadosClienteFromView() {
		cliente.setNome(textFieldNome.getText());
		cliente.setCpf(textFieldCPF.getText());
		cliente.setCidade(textFieldCidade.getText());
		cliente.setCep(textFieldCEP.getText());
		cliente.setRua(textFieldRua.getText());
		cliente.setBairro(textFieldBairro.getText());
		cliente.setTelefone(textFieldTelefone.getText());
	}
	
	private void incluirCliente() {
		clienteService.save(cliente);
		limparCampos();
	}
	
	private void alterarCliente() {
		clienteService.update(cliente);
		limparCampos();
	}
	
	private void buscarCliente() {
	
		Integer id = 0; 
		
		if(!textFieldId.getText().equals("")) {
			
			id = Integer.parseInt(textFieldId.getText());
			cliente = clienteService.findClienteById(id);
			
			textFieldNome.setText(cliente.getNome());
			textFieldCPF.setText(cliente.getCpf());
			textFieldCidade.setText(cliente.getCidade());
			textFieldCEP.setText(cliente.getCep());
			textFieldRua.setText(cliente.getRua());
			textFieldBairro.setText(cliente.getBairro());
			textFieldTelefone.setText(cliente.getTelefone());
		}
		
		
	}
	
	private void excluirCliente() {
		clienteService.delete(cliente);
		limparCampos();
	}
}
