package sistema.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaConsultaEmprestimo  extends JFrame{
	 
		
		private static final long serialVersionUID = 1L;
		private JTable tblEmp;
		private JButton btnPesquisar;
		private JTextField txtPesquisa;
		
		

		public TelaConsultaEmprestimo() {
			setSize(400, 400);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Consulta de Emprestimos e Devolucoes");
			setLocationRelativeTo(null);
			
			JPanel pane = new JPanel();
			pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			setContentPane(pane);
			
			BorderLayout layout = new BorderLayout();
			layout.setHgap(5);
			layout.setVgap(5);
			setLayout(layout);
					
			JPanel topo = new JPanel();		
			topo.setLayout(new BoxLayout(topo, BoxLayout.LINE_AXIS));
			add(topo, BorderLayout.NORTH);
			
			txtPesquisa = new JTextField();
			topo.add(txtPesquisa);
			topo.add(Box.createRigidArea(new Dimension(0, 10)));
			
			btnPesquisar = new JButton("Pesquisar");
			topo.add(btnPesquisar);
			
			

			
			tblEmp = new JTable();
			add(new JScrollPane(tblEmp), BorderLayout.CENTER);
		}

		public JTable getTable() {
			return tblEmp;
		}
		
		public JButton getBtnPesquisar() {
			return btnPesquisar;
		}
		
		public JTextField getTxtPesquisa() {
			return txtPesquisa;
		}
		
	}


