package sistema.controles;

import java.sql.SQLException;

import sistema.dados.FabricaDados;
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
	
	public FabricaControles(FabricaDados fabricaDados, FabricaTelas fabricaTelas) throws SQLException {
		this.consultaAlunosControle = new ConsultaAlunosControle(fabricaTelas.getTelaConsultaAlunos(), fabricaDados.getAlunoDados());
		this.menuPrincipalControle = new MenuPrincipalControle(fabricaTelas.getTelaMenuPrincipal(), consultaAlunosControle);
	}

	public MenuPrincipalControle getControleMenuPrincipal() {
		return menuPrincipalControle;
	}

	public ConsultaAlunosControle getControleConsultaAluno() {
		return consultaAlunosControle;
	}
	
}
