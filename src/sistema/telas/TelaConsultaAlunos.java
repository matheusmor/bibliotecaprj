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

/**
 * Apenas uma tela Swing sem lógica e com os principais componentes disponíveis 
 * via getters para que algum controlador adicione lógica.
 * 
 * Telas não conhecem nenhum outro tipo do sistema.
 * 
 * @author Emerson C. Lima
 */
public class TelaConsultaAlunos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable tblAlunos;
	private JButton btnPesquisar;
	private JTextField txtPesquisa;
	private JCheckBox ckPendencia;
	

	public TelaConsultaAlunos() {
		setSize(400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Consulta alunos");
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
		
		ckPendencia = new JCheckBox("pendencias");
		topo.add(ckPendencia);

		
		tblAlunos = new JTable();
		add(new JScrollPane(tblAlunos), BorderLayout.CENTER);
	}

	public JTable getTable() {
		return tblAlunos;
	}
	
	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}
	
	public JTextField getTxtPesquisa() {
		return txtPesquisa;
	}
	public JCheckBox getCheckBoxValida() {
		return ckPendencia;
	}
}
