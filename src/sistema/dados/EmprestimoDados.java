package sistema.dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Aluno;
import sistema.modelos.Emprestimo;
import sistema.modelos.Livro;

public class EmprestimoDados {
	

	private Connection conexao;

	public EmprestimoDados(Connection conexao) {
		this.conexao = conexao;
	}
		
	public List<Emprestimo> todos() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT alunos.nome, livros.nome, data_emprestimo, data_prevista_devolucao FROM emprestimos, alunos, livros WHERE alunos.id = emprestimos.aluno AND livros.id = emprestimos.livro;");
		ResultSet rs = stmt.getResultSet();
		List<Emprestimo> emprestimos = new ArrayList<>();
		while (rs.next()) {
			Emprestimo e = new Emprestimo();
			
			e.setNome(rs.getString(1));
			e.setLivro(rs.getString(2));
			e.setDt_emprestimo(rs.getDate(3));
			e.setDt_prevdevolucao(rs.getDate(4));
			emprestimos.add(e);
		}
		return emprestimos;
	}

	public List<Emprestimo> buscaPorNome(String nome) throws SQLException {
		
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT alunos.nome FROM alunos where (nome) like('%" +nome+ "%')");
		ResultSet rs = stmt.getResultSet();
		List<Emprestimo> emprestimo = new ArrayList<>();
		while (rs.next()) {
			Emprestimo a = new Emprestimo();
			a.setNome(rs.getString(1));
			
			
			emprestimo.add(a);
		}
		return emprestimo;
	}
	


	public List<Emprestimo> pegaPorLivro(String nome) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT livros.nome FROM livros where (nome) like('%" +nome+ "%')");
		ResultSet rs = stmt.getResultSet();
		List<Emprestimo> emprestimo= new ArrayList<>();
		while (rs.next()) {
			Emprestimo a = new Emprestimo();
			a.setLivro(rs.getString(2));
			
			
			emprestimo.add(a);
		}
		return emprestimo;
	}
	
	

	

	public void atualiza(Livro a) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	public void apaga(Livro a) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	
	
	
	public List<Emprestimo> todosPendentes() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT alunos.nome,livros.nome,data_prevista_devolucao FROM alunos,emprestimos, livros where alunos.id = emprestimos.aluno AND livro.id = emprestimos.livro;");
		ResultSet rs = stmt.getResultSet();
		List<Emprestimo> emprestimo = new ArrayList<>();
		while (rs.next()) {
			Emprestimo e = new Emprestimo();
			e.setNome(rs.getString(1));
			e.setLivro(rs.getString(2));
			e.setDt_prevdevolucao(rs.getDate(3));
			
			emprestimo.add(e);
		}
		return emprestimo;
	}

	
}





