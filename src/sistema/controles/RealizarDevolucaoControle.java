package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import sistema.dados.EmprestimoDados;
import sistema.telas.TelaRealizarDevolucao;


public class RealizarDevolucaoControle {
	


		private TelaRealizarDevolucao tela;
		
		public  RealizarDevolucaoControle(TelaRealizarDevolucao tela, EmprestimoDados empDados) throws SQLException {
			this.tela =  tela;
			tela.getSalvar().addActionListener((ActionEvent e)-> {
				String idnome = tela.getTnome().getText();
				String idlivro = tela.getTlivro().getText();
				
				
				try {
					empDados.RealizarDevolucao(idnome, idlivro);
					JOptionPane.showMessageDialog(null, "Devolucao realizada com Sucesso!", "uhul!", JOptionPane.INFORMATION_MESSAGE, null);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "deu merda", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);
					
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

