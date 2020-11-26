package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.UIManager;

import sistema.controles.FabricaControles;
import sistema.dados.AlunoDados;
import sistema.dados.EmprestimoDados;
import sistema.dados.FabricaDados;
import sistema.dados.LivroDados;
import sistema.telas.FabricaTelas;

/**
 * Ponto de partida da aplicação.
 * 
 * @author Emerson C. Lima
 *
 */
public class Principal {

	public static Connection abrirConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://134.209.243.185:5432/biblioteca", "biblioteca", "3A1Y5azlK0A=");
	}
	
	public static void main(String[] args) throws Exception {		
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		Connection conexao = abrirConexao();
		FabricaDados fabricaDados = new FabricaDados(conexao);
		FabricaTelas fabricaTelas = new FabricaTelas();
		AlunoDados alunoDados = new AlunoDados(conexao);
		LivroDados livroDados = new LivroDados(conexao);
		EmprestimoDados empDados = new EmprestimoDados(conexao);
		
		
		FabricaControles fabricaControles = new FabricaControles(fabricaDados, fabricaTelas, alunoDados, livroDados, empDados, empDados);
		fabricaControles.getControleMenuPrincipal().mostra();
		
	}
	
}
