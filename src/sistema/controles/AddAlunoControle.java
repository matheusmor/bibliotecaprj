package sistema.controles;

import java.awt.event.ActionEvent;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import sistema.dados.AlunoDados;
import sistema.telas.TelaAddAluno;

public class AddAlunoControle {

	private TelaAddAluno tela;
	
	public  AddAlunoControle(TelaAddAluno  tela, AlunoDados alunoDados) throws SQLException {
		this.tela =  tela;
		tela.getSalvar().addActionListener((ActionEvent e)-> {
			String nome = tela.getTnome().getText();
			String email = tela.getTEmail().getText();
			
			try {
				alunoDados.insere(nome,email);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Esse Nome/Email ja esta sendo Usado. Tente outro.", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);
				e1.printStackTrace();
			}
		});
		tela.getCancelar().addActionListener((ActionEvent e) ->{
			if(e.getSource() == tela.getCancelar()) {
				tela.dispose();
				
			}
			
			
		});
	}

	public void mostra() {
		this.tela.setVisible(true);
		
	} 
	
}
