package sistema.dados;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import sistema.modelos.Aluno;
/**
 * Classe responsável pela consulta e alteração dos dados.
 * 
 * Basicamente os comandos SQL necessários viram sempre um método.
 * 
 * Exemplo:
 * 	SELECT * FROM Aluno; -> List<Aluno> todos();
 *  INSERT INTO Aluno ...; -> void insere(Aluno a);
 *  
 *  
 * Esta classe depende de uma instância de Connection a ser passada no 
 * construtor.
 * 
 * Esta classe não deve conhecer nada sobre telas, controladores, e etc.
 * 
 * Ela deve conhecer apenas com os tipos definidos no pacote modelos e outros 
 * Dados desse pacote.
 * 
 * @author Emerson C. Lima
 */
public class AlunoDados {

	private Connection conexao;

	public AlunoDados(Connection conexao) {
		this.conexao = conexao;
	}
		
	public List<Aluno> todos() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM alunos");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}

	public List<Aluno> buscaPorNome(String nome) throws SQLException {
		
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT alunos.nome FROM alunos where (nome) like('%" +nome+ "%')");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}
	

	public List<Aluno> buscaPorEmail(String email) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	public Aluno pegaPorId(long id) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	public void insere(Aluno a) throws SQLException {
		
	}
	public void insere(String nome, String email) throws SQLException {
		Statement stmt = conexao.createStatement();;
		
		stmt.execute("INSERT INTO \"public\".\"alunos\" (\"nome\", \"email\") VALUES ('" + nome +  "','" + email +  "');");
		
		
	}
	

	public void atualiza(Aluno a) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	public void apaga(Aluno a) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}
	
	
	public List<Aluno> todosPendentes() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM alunos inner join emprestimos on emprestimos.aluno=alunos.id  where data_devolucao is null");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}

	
}
