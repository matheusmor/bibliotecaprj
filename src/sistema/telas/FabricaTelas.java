package sistema.telas;

/**
 * Fábrica de telas.
 * 
 * Apenas constrói as telas. Sem lógica alguma. 
 * 
 * @author Emerson C. Lima
 */
public class FabricaTelas {
	private TelaAddAluno telaAddAluno;
	private TelaMenuPrincipal telaMenuPrincipal;
	private TelaConsultaAlunos telaConsultaAlunos;
	private TelaAddLivro telaAddLivro;
	private TelaConsultaLivro telaConsultaLivro;
	private TelaConsultaEmprestimo telaConsultaEmprestimo;
	
	public FabricaTelas() {
		telaMenuPrincipal = new TelaMenuPrincipal();
		telaConsultaAlunos = new TelaConsultaAlunos();
		telaAddAluno = new TelaAddAluno();
		telaAddLivro = new TelaAddLivro();
		telaConsultaLivro = new TelaConsultaLivro();
		telaConsultaEmprestimo = new TelaConsultaEmprestimo();
	}
	
	public TelaConsultaEmprestimo getTelaConsultaEmprestimo() {
		return telaConsultaEmprestimo;
	}

	public TelaAddLivro getTelaAddLivro() {
		return telaAddLivro;
	}

	public TelaMenuPrincipal getTelaMenuPrincipal() {
		return telaMenuPrincipal;
	}
	
	public TelaAddAluno getTelaAddAluno() {
		return telaAddAluno;
	}

	public TelaConsultaLivro getTelaConsultaLivros() {
		return telaConsultaLivro;
	}

	public TelaConsultaAlunos getTelaConsultaAlunos() {
		return telaConsultaAlunos;
	}
	
}
