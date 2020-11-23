package sistema.modelos;

/**
 * Classes Java Simples (POJO) com getters e setters apenas.
 * Não conhecem nenhuma outra classe da aplicação. A aplicação é que faz uso 
 * dessas classes o tempo todo.
 * 
 * @author Emerson C. Lima
 *
 */
public class Aluno {
	
	/*
	 * Defina os atributos você mesmo, o resto da classe o eclipse gera.
	 */
	private long id;
	private String nome;
	private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * Use o eclipse para gerar o método toString() para você
	 */
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + "]";
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
		Aluno other = (Aluno) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
