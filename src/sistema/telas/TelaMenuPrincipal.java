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
	private JMenuItem mnuConsultarLivros;
	private JMenuItem mnuAdicionarLivros;
	private JMenuItem mnuConsulEmprestimo;
	private JMenuItem mnuRealizarDevolucao;
	private JMenuItem mnuRealizarEmprestimo;
	
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
		mnuAdicionarAlunos = new JMenuItem("Adicionar alunos");
		mnuAdicionarLivros = new JMenuItem("Adicionar livros");
		mnuConsultarLivros = new JMenuItem("Consultar livros");
		mnuRealizarDevolucao = new JMenuItem("Realizar devolucoes");
		mnuConsulEmprestimo = new JMenuItem("Realizar Emprestimos");
		mnuRealizarEmprestimo = new JMenuItem("Consultar Emps. e Devs. ");
		
		
		JMenu mnuLivros = new JMenu("Livros");
		menubar.add(mnuLivros);
		
		JMenu mnuEmprestimo = new JMenu("Emprestimos");
		menubar.add(mnuEmprestimo);
		
		mnuAlunos.add(mnuConsultarAlunos);
		mnuAlunos.add(mnuAdicionarAlunos);
		mnuSistema.add(mnuSair);
		
		mnuLivros.add(mnuConsultarLivros);
		mnuLivros.add(mnuAdicionarLivros);
		
		mnuEmprestimo.add(mnuRealizarDevolucao);
		mnuEmprestimo.add(mnuConsulEmprestimo);
		mnuEmprestimo.add(mnuRealizarEmprestimo);
		setJMenuBar(menubar);
	}
		

	public JMenuItem getMnuRealizarEmprestimo() {
		return mnuConsulEmprestimo;
	}


	public JMenuItem getMnuRealizarDevolucao() {
		return mnuRealizarDevolucao;
	}


	public JMenuItem getMnuConsultarEmpDev() {
		return mnuRealizarEmprestimo;
	}


	public JMenuItem getMnuConsultarLivros() {
		return mnuConsultarLivros;
	}


	public JMenuItem getMnuAdicionarLivros() {
		return mnuAdicionarLivros;
	}


	public JMenuItem getSair() { 
		return mnuSair;
	}

	public JMenuItem getConsultarAlunos() {
		return mnuConsultarAlunos;
	}
	
	public JMenuItem getAddAluno() {
		return mnuAdicionarAlunos;
		
	}
}
