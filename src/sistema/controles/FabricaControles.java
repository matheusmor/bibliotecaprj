package sistema.controles;

import java.sql.SQLException;

import sistema.dados.AlunoDados;
import sistema.dados.EmprestimoDados;
import sistema.dados.FabricaDados;
import sistema.dados.LivroDados;
import sistema.telas.FabricaTelas;

/**
 * Classe responsável por construir os controladores da aplicação, ou seja, 
 * instânciar e conectar as instâncias dos controladores com suas dependencias.
 *
 * Usa outras fábricas para adquirir instâncias das telas e 
 * instâncias de acesso aos dados.
 * 
 * 
 * Ela só pode interagir com controladores do próprio pacote ou outras fábricas.
 * 
 * @author Emerson C. Lima
 */
public class FabricaControles {

	private MenuPrincipalControle menuPrincipalControle;
	private ConsultaAlunosControle consultaAlunosControle;
	private AddAlunoControle addAluno;
	private AddLivroControle addLivro;
	private ConsultaLivrosControle consultaLivroControle;
	private ConsulEmprestimoControle consulEmprestimoControle;
	
	public FabricaControles(FabricaDados fabricaDados, FabricaTelas fabricaTelas, AlunoDados alunoDados, LivroDados livroDados, EmprestimoDados empDados) throws SQLException {
		
		this.addAluno = new AddAlunoControle(fabricaTelas.getTelaAddAluno(), alunoDados );
		this.addLivro = new AddLivroControle(fabricaTelas.getTelaAddLivro(), livroDados);
		this.consulEmprestimoControle = new ConsulEmprestimoControle(fabricaTelas.getTelaConsultaEmprestimo(), fabricaDados.getEmpDados());
		this.consultaLivroControle = new ConsultaLivrosControle(fabricaTelas.getTelaConsultaLivros(),fabricaDados.getLivroDados());
		
		this.consultaAlunosControle = new ConsultaAlunosControle(fabricaTelas.getTelaConsultaAlunos(), fabricaDados.getAlunoDados());
		this.menuPrincipalControle = new MenuPrincipalControle(fabricaTelas.getTelaMenuPrincipal(), consultaAlunosControle, addAluno, addLivro, consultaLivroControle, consulEmprestimoControle);
		
	}

	public ConsultaLivrosControle getConsultaLivroControle() {
		return consultaLivroControle;
	}

	public MenuPrincipalControle getControleMenuPrincipal() {
		return menuPrincipalControle;
	}

	public ConsultaAlunosControle getControleConsultaAluno() {
		return consultaAlunosControle;
	}
	public AddAlunoControle addAluno () {
		return addAluno;
	}
	
	public AddLivroControle addLivro () {
		return addLivro;
		
	}

	public ConsulEmprestimoControle getConsulEmprestimoControle() {
		return consulEmprestimoControle;
	}

}
