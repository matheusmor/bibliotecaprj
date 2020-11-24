package sistema.modelos;


	public class Livro {
		
		/*
		 * Defina os atributos você mesmo, o resto da classe o eclipse gera.
		 */
		private long id;
		private String nome;
		
		
		/*
		 * Use o eclipse para gerar os getters e setters
		 */
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}	
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		/*
		 * Use o eclipse para gerar o método toString() para você
		 */
		@Override
		public String toString() {
			return "Livro [id=" + id + ", nome=" + nome + "]";
		}
		
		/*
		 * Use o eclipse para gerar os métodos equals e hashCode para você
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
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
			Livro other = (Livro) obj;
			if (id != other.id)
				return false;
			return true;
		}	
		
	}
	
	

