package sistema.dados;

import java.sql.Connection;

/**
 * Classe responsável por construir objetos do tipo Dados do pacote, ou seja, 
 * instânciar e conectar as instâncias dos dados com suas dependencias.
 *
 * Ela só pode interagir com outros dados do próprio pacote.
 * 
 * @author Emerson C. Lima
 */
public class FabricaDados {

	private AlunoDados alunoDados;
	private LivroDados livroDados;
	private EmprestimoDados empDados;
	public FabricaDados(Connection conexao) {		
	
		this.alunoDados = new AlunoDados(conexao);
		this.livroDados = new LivroDados(conexao);
		this.empDados = new EmprestimoDados(conexao);
	}
	
	public EmprestimoDados getEmpDados() {
		return empDados;
	}

	public LivroDados getLivroDados() {
		return livroDados;
	}

	public AlunoDados getAlunoDados() {
		return alunoDados;
	}
	
}
