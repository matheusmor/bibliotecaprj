package sistema.modelos;

import java.sql.Date;

public class Emprestimo {
		
	
	
	 
		
		/*
		 * Defina os atributos você mesmo, o resto da classe o eclipse gera.
		 */
		
		private String nome;
		private String livro;
		
		private Date dt_emprestimo;
		private Date dt_prevdevolucao; 
		private Date dt_devolucao;
		
		
		
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getLivro() {
			return livro;
		}
		public void setLivro(String livro) {
			this.livro = livro;
		}
	
		public Date getDt_emprestimo() {
			return dt_emprestimo;
		}
		public void setDt_emprestimo(Date dt_emprestimo) {
			this.dt_emprestimo = dt_emprestimo;
		}
		public Date getDt_prevdevolucao() {
			return dt_prevdevolucao;
		}
		public void setDt_prevdevolucao(Date dt_prevdevolucao) {
			this.dt_prevdevolucao = dt_prevdevolucao;
		}
		public Date getDt_devolucao() {
			return dt_devolucao;
		}
		public void setDt_devolucao(Date dt_devolucao) {
			this.dt_devolucao = dt_devolucao;
		}
		
	
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dt_devolucao == null) ? 0 : dt_devolucao.hashCode());
			result = prime * result + ((dt_emprestimo == null) ? 0 : dt_emprestimo.hashCode());
			result = prime * result + ((dt_prevdevolucao == null) ? 0 : dt_prevdevolucao.hashCode());
			result = prime * result + ((livro == null) ? 0 : livro.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			return result;
		}
	
		
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Emprestimo other = (Emprestimo) obj;
			if (dt_devolucao == null) {
				if (other.dt_devolucao != null)
					return false;
			} else if (!dt_devolucao.equals(other.dt_devolucao))
				return false;
			if (dt_emprestimo == null) {
				if (other.dt_emprestimo != null)
					return false;
			} else if (!dt_emprestimo.equals(other.dt_emprestimo))
				return false;
			if (dt_prevdevolucao == null) {
				if (other.dt_prevdevolucao != null)
					return false;
			} else if (!dt_prevdevolucao.equals(other.dt_prevdevolucao))
				return false;
		
			if (livro == null) {
				if (other.livro != null)
					return false;
			} else if (!livro.equals(other.livro))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Emprestimo [nome=" + nome + ", livro=" + livro + ", dt_emprestimo=" + dt_emprestimo
					+ ", dt_prevdevolucao=" + dt_prevdevolucao + ", dt_devolucao=" + dt_devolucao + "]";
		}
	
		
		
		

}