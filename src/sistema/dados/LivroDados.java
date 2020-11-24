package sistema.dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Aluno;
import sistema.modelos.Livro;

public class LivroDados {
	
	

		private Connection conexao;

		public LivroDados(Connection conexao) {
			this.conexao = conexao;
		}
			
		public List<Livro> todos() throws SQLException {
			Statement stmt = conexao.createStatement();
			stmt.execute("SELECT * FROM livros");
			ResultSet rs = stmt.getResultSet();
			List<Livro> livro = new ArrayList<>();
			while (rs.next()) {
				Livro a = new Livro();
				a.setId(rs.getLong(1));
				a.setNome(rs.getString(2));
				livro.add(a);
			}
			return livro;
		}

		public List<Livro> buscaPorNome(String nome) throws SQLException {
			
			Statement stmt = conexao.createStatement();
			stmt.execute("SELECT livro.nome FROM livro where (nome) like('%" +nome+ "%')");
			ResultSet rs = stmt.getResultSet();
			List<Livro> livro = new ArrayList<>();
			while (rs.next()) {
				Livro a = new Livro();
				a.setId(rs.getLong(1));
				a.setNome(rs.getString(2));
				
				livro.add(a);
			}
			return livro;
		}
		

	
		public Aluno pegaPorId(long id) throws SQLException {
			throw new UnsupportedOperationException("Não implementado ainda!");
		}

		public void insere(String nome) throws SQLException {
			Statement stmt = conexao.createStatement();;
			
			stmt.execute("INSERT INTO \"public\".\"livros\" (\"nome\") VALUES ('" + nome +  "');");
			
			
			
		}
		public void insere(String nome, String email) throws SQLException {
			Statement stmt = conexao.createStatement();;
			
			stmt.execute("INSERT INTO \"public\".\"livros\" (\"nome\") VALUES ('" + nome +  "');");
			
			
		}
		

		public void atualiza(Livro a) throws SQLException {
			throw new UnsupportedOperationException("Não implementado ainda!");
		}

		public void apaga(Livro a) throws SQLException {
			throw new UnsupportedOperationException("Não implementado ainda!");
		}
		
		
		public List<Livro> todosPendentes() throws SQLException {
			Statement stmt = conexao.createStatement();
			stmt.execute("SELECT * FROM livros inner join emprestimos on emprestimos.livro=livros.id  where data_devolucao is null");
			ResultSet rs = stmt.getResultSet();
			List<Livro> livros = new ArrayList<>();
			while (rs.next()) {
				Livro a = new Livro();
				a.setId(rs.getLong(1));
				a.setNome(rs.getString(2));
				
				livros.add(a);
			}
			return livros;
		}

		
	}
	
	

