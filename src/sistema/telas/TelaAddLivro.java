package sistema.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAddLivro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Tnome;
	
	private JButton cancelar;
	private JButton salvar;

	public TelaAddLivro() {

		JLabel nome = new JLabel("Nome");
		Tnome = new JTextField(30);

	

		cancelar = new JButton("cancelar");
		salvar = new JButton("Salvar");

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2, 3, 3));
		
		getContentPane().add(p1, BorderLayout.CENTER);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(p2, BorderLayout.SOUTH);

		setTitle("Novo Aluno");
		setSize(420, 200);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// jlabel

		p1.add(nome);
		p1.add(Tnome);

		// botoes

		p2.add(cancelar);
		p2.add(salvar);

		
		
		
	}

	public JTextField getTnome() {
		return Tnome;
	}

	

	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getSalvar() {
		return salvar;
	}

}