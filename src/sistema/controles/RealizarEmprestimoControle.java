package sistema.controles;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import sistema.dados.EmprestimoDados;
import sistema.telas.TelaRealizarEmprestimo;

public class RealizarEmprestimoControle {


		private TelaRealizarEmprestimo tela;
		
		public  RealizarEmprestimoControle(TelaRealizarEmprestimo tela, EmprestimoDados empDados) throws SQLException {
			this.tela =  tela;
			tela.getSalvar().addActionListener((ActionEvent e)-> {
				String idnome = tela.getTnome().getText();
				String idlivro = tela.getTlivro().getText();
				long longo = System.currentTimeMillis();
				Date dataprevdev = new Date(longo);
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(dataprevdev);
				calendario.add(Calendar.DATE, 30);
				dataprevdev = calendario.getTime();
				
				try {
					empDados.RealizarEmprestimo(idnome, idlivro, new java.sql.Date(dataprevdev.getTime()));
					JOptionPane.showMessageDialog(null, "Emprestimo realizado com Sucesso!", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);
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
