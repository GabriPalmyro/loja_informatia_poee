package com.projeto.main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import com.projeto.view.aparelho.AparelhoFrame;
import com.projeto.view.cliente.ClienteFrame;
import com.projeto.view.cliente.TabelaCliente;

public class Projeto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1258866171126118496L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projeto frame = new Projeto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Projeto() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 661, 439);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		
		initComponents();
		createEvents();
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}

	private void initComponents() {
		//ClienteFrame clienteFrame = new ClienteFrame();
		//clienteFrame.setVisible(true);
		//AparelhoFrame aparelhoFrame = new AparelhoFrame();
		//aparelhoFrame.setVisible(true);
		
		TabelaCliente tabelaCliente = new TabelaCliente();
		tabelaCliente.setVisible(true);
	}
	

}
