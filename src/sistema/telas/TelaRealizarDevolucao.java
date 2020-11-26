package sistema.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaRealizarDevolucao extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JTextField Tnome;
		private JTextField Tlivro;
		private JButton cancelar;
		private JButton emprestar;
		
		public TelaRealizarDevolucao() {
		
			
			

			JLabel nome = new JLabel("Nome");
			Tnome = new JTextField(30);
			
			JLabel Livro = new JLabel("Livro");
			Tlivro = new JTextField(30);

		

			cancelar = new JButton("cancelar");
			emprestar = new JButton("devolver");

			JPanel p1 = new JPanel();
			p1.setLayout(new GridLayout(4, 2, 3, 3));
			
			getContentPane().add(p1, BorderLayout.CENTER);

			JPanel p2 = new JPanel();
			p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(p2, BorderLayout.SOUTH);

			setTitle("Realizar Devolucao");
			setSize(420, 200);
			
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);

			// jlabel
		
			p1.add(nome);
			p1.add(Tnome);
			p1.add(Livro);
			p1.add(Tlivro);
			// botoes

			p2.add(cancelar);
			p2.add(emprestar);

			
			
			
		}

		public JTextField getTlivro() {
			return Tlivro;
		}

		public JTextField getTnome() {
			return Tnome;
		}

		

		public JButton getCancelar() {
			return cancelar;
		}

		public JButton getSalvar() {
			return emprestar;
		}

	}

