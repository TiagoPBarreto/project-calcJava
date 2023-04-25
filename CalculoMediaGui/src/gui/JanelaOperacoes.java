package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import calculo.media.gui.Pessoa;
import calculo.media.gui.Processos;

public class JanelaOperacoes extends JFrame implements ActionListener {

	private JPanel painelPrincipal;
	private JTextField textNome;
	private JTextField textNota1;
	private JTextField textNota2;
	private JTextField textNota3;
	private JButton btnCalcular;
	private JLabel lblResMedia;
	private JLabel lblResultado;
	
	Processos misProcessos;
	private JButton btnImprimirTotal;
	private JButton btnConsultarEstudante;
	private JTextField textDocumento;

	public JanelaOperacoes() {
		misProcessos = new Processos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(491, 481);
		setTitle("Calculo de Media");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
		
		
	}
	
	private void iniciarComponentes(){
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Calcular Media");
		lblTitulo.setBackground(Color.black);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 11, 475, 45);
		painelPrincipal.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 71, 68, 31);
		painelPrincipal.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(63, 67, 183, 51);
		painelPrincipal.add(textNome);
		textNome.setColumns(10);
		
		textNota1 = new JTextField();
		textNota1.setColumns(10);
		textNota1.setBounds(63, 135, 55, 51);
		textNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		painelPrincipal.add(textNota1);
		
		JLabel lblNota1 = new JLabel("Nota1");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(10, 139, 68, 31);
		painelPrincipal.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota2");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(138, 139, 68, 31);
		painelPrincipal.add(lblNota2);
		
		textNota2 = new JTextField();
		textNota2.setColumns(10);
		textNota2.setBounds(191, 135, 55, 51);
		textNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		painelPrincipal.add(textNota2);
		
		JLabel lblNota3 = new JLabel("Nota3");
		lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota3.setBounds(264, 139, 68, 31);
		painelPrincipal.add(lblNota3);
		
		textNota3 = new JTextField();
		textNota3.setColumns(10);
		textNota3.setBounds(317, 135, 55, 51);
		textNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		painelPrincipal.add(textNota3);
		
		JLabel lblMedia = new JLabel("Media:");
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMedia.setBounds(10, 228, 108, 39);
		painelPrincipal.add(lblMedia);
		
		lblResMedia = new JLabel("");
		lblResMedia.setBounds(94, 228, 149, 32);
		painelPrincipal.add(lblResMedia);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(10, 278, 378, 39);
		painelPrincipal.add(lblResultado);
		
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCalcular.setBounds(248, 197, 129, 39);
		btnCalcular.addActionListener(this);
		painelPrincipal.add(btnCalcular);
		
		btnImprimirTotal = new JButton();
		btnImprimirTotal.setText("Imprimir Total");
		btnImprimirTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnImprimirTotal.setBounds(10, 357, 179, 39);
		btnImprimirTotal.addActionListener(this);
		painelPrincipal.add(btnImprimirTotal);
		
		btnConsultarEstudante = new JButton();
		btnConsultarEstudante.setText("Consultar");
		btnConsultarEstudante.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultarEstudante.setBounds(255, 357, 179, 39);
		btnConsultarEstudante.addActionListener(this);
		painelPrincipal.add(btnConsultarEstudante);
		
		textDocumento = new JTextField();
		textDocumento.setColumns(10);
		textDocumento.setBounds(251, 67, 183, 51);
		painelPrincipal.add(textDocumento);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCalcular) {
			calcularMedia();
		}
		else if(e.getSource()==btnImprimirTotal) {
			misProcessos.imprimirEstudantes();
		}
		else if(e.getSource()==btnConsultarEstudante) {
			JanelaConsulta miJanelaConsulta = new JanelaConsulta();
			miJanelaConsulta.assinarProcesso(misProcessos);
			miJanelaConsulta.setVisible(true);
		}
		
		
	}

	private void calcularMedia() {
		
		Pessoa estudante = new Pessoa();
		
		estudante.setNome(textNome.getText());
		estudante.setDocumento(textDocumento.getText());
		
		
		try {
			estudante.setNota1(Double.parseDouble(textNota1.getText()));
			estudante.setNota2(Double.parseDouble(textNota2.getText()));
			estudante.setNota3(Double.parseDouble(textNota3.getText()));
			double media = misProcessos.calcularMedia(estudante);
			
			estudante.setMedia(misProcessos.calcularMedia(estudante));
			
			lblResMedia.setText(estudante.getMedia()+"");
			
			String resultado = misProcessos.calcularDefinitiva(estudante.getMedia());
			
			misProcessos.registrarEmBd(estudante);
			
			if(resultado.equals("Passou")) {
				lblResultado.setText("Resultado: Passou");
				lblResultado.setForeground(Color.green);
			}
			else {
				lblResultado.setText("Resultado: Reprovou");
				lblResultado.setForeground(Color.red);
			}
			
		} 
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "erro de entrada de texto",
					"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, por favor verifique os dados",
					"ERROR",JOptionPane.ERROR_MESSAGE);
		}

		
	}
}
