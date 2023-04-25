package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import calculo.media.gui.Pessoa;
import calculo.media.gui.Processos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaConsulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textNota1;
	private JTextField textNota2;
	private JTextField textNota3;
	private JTextField textDoc;
	private JButton btnConsultar;
	private Processos misProcessos;

	/**
	 * Create the frame.
	 */
	public JanelaConsulta()  {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 447);
		getContentPane().setLayout(null);
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(null);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPrincipal.setBounds(0, -13, 475, 442);
		getContentPane().add(painelPrincipal);
		
		JLabel lblTitulo = new JLabel("Consultar");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setBounds(0, 11, 475, 45);
		painelPrincipal.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 123, 68, 31);
		painelPrincipal.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(63, 119, 307, 51);
		painelPrincipal.add(textNome);
		
		textNota1 = new JTextField();
		textNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNota1.setColumns(10);
		textNota1.setBounds(63, 187, 55, 51);
		painelPrincipal.add(textNota1);
		
		JLabel lblNota1 = new JLabel("Nota1");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(10, 191, 68, 31);
		painelPrincipal.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota2");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(138, 139, 68, 31);
		painelPrincipal.add(lblNota2);
		
		textNota2 = new JTextField();
		textNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNota2.setColumns(10);
		textNota2.setBounds(191, 187, 55, 51);
		painelPrincipal.add(textNota2);
		
		JLabel lblNota3 = new JLabel("Nota3");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(264, 191, 68, 31);
		painelPrincipal.add(lblNota3);
		
		textNota3 = new JTextField();
		textNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNota3.setColumns(10);
		textNota3.setBounds(317, 187, 55, 51);
		painelPrincipal.add(textNota3);
		
		JLabel lblMedia = new JLabel("Media:");
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMedia.setBounds(10, 299, 108, 39);
		painelPrincipal.add(lblMedia);
		
		JLabel lblResMedia = new JLabel("");
		lblResMedia.setBounds(94, 299, 149, 51);
		painelPrincipal.add(lblResMedia);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(10, 349, 378, 39);
		painelPrincipal.add(lblResultado);
		
		btnConsultar = new JButton();
		btnConsultar.setText("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBounds(248, 249, 129, 39);
		btnConsultar.addActionListener(this);
		painelPrincipal.add(btnConsultar);
		
		JLabel lblDoc = new JLabel("Documento");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(222, 81, 84, 31);
		painelPrincipal.add(lblDoc);
		
		textDoc = new JTextField();
		textDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDoc.setColumns(10);
		textDoc.setBounds(315, 67, 55, 51);
		painelPrincipal.add(textDoc);
		
	}
	
	public void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));

		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnConsultar) {
			Pessoa miEstudante =  misProcessos.obterEstudante(textDoc.getText());
			
			if(miEstudante != null) {
				textNome.setText(miEstudante.getNome());
				textNota1.setText(miEstudante.getNota1()+"");
				textNota2.setText(miEstudante.getNota2()+"");
				textNota3.setText(miEstudante.getNota3()+"");
			}
			else {
				JOptionPane.showMessageDialog(null, "Esse documento não existe");
			}
			
		}
	}

	public void assinarProcesso(Processos misProcessos) {
		this.misProcessos = misProcessos;
		
	}
}
