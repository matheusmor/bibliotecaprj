package sistema.telas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import sistema.telas.TelaMenuPrincipal;

/**
 * Apenas uma tela Swing sem lógica e com os principais componentes disponíveis 
 * via getters para que algum controlador adicione lógica.
 * 
 * Telas não conhecem nenhum outro tipo do sistema.
 * 
 * @author Emerson C. Lima
 */
public class TelaMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JMenuItem mnuSair;
	private JMenuItem mnuConsultarAlunos;
	private JMenuItem mnuAdicionarAlunos;

	public TelaMenuPrincipal() {	
		setSize(600, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Menu principal");
		setLocationRelativeTo(null);
		JMenuBar menubar = new JMenuBar();
		JMenu mnuSistema = new JMenu("Sistema");
		menubar.add(mnuSistema);
		mnuSair = new JMenuItem("Sair");
		
		JMenu mnuAlunos = new JMenu("Alunos");
		menubar.add(mnuAlunos);
		mnuConsultarAlunos = new JMenuItem("Consultar alunos");
		mnuAlunos.add(mnuConsultarAlunos);
		mnuAdicionarAlunos = new JMenuItem("Adicionar alunos");
		mnuAlunos.add(mnuAdicionarAlunos);
		
		mnuSistema.add(mnuSair);
		setJMenuBar(menubar);
	}
		

	public JMenuItem getSair() { 
		return mnuSair;
	}

	public JMenuItem getConsultarAlunos() {
		return mnuConsultarAlunos;
	}
	
}
