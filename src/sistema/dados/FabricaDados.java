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

	public FabricaDados(Connection conexao) {		
		this.alunoDados = new AlunoDados(conexao);
	}
	
	public AlunoDados getAlunoDados() {
		return alunoDados;
	}
	
}
