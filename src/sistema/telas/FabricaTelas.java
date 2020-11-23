package sistema.telas;

/**
 * Fábrica de telas.
 * 
 * Apenas constrói as telas. Sem lógica alguma. 
 * 
 * @author Emerson C. Lima
 */
public class FabricaTelas {

	private TelaMenuPrincipal telaMenuPrincipal;
	private TelaConsultaAlunos telaConsultaAlunos;

	public FabricaTelas() {
		telaMenuPrincipal = new TelaMenuPrincipal();
		telaConsultaAlunos = new TelaConsultaAlunos();
	}
	
	public TelaMenuPrincipal getTelaMenuPrincipal() {
		return telaMenuPrincipal;
	}
	
	public TelaConsultaAlunos getTelaConsultaAlunos() {
		return telaConsultaAlunos;
	}
}
