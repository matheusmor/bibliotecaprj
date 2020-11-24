package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sistema.dados.LivroDados;
import sistema.telas.TelaAddLivro;



	public class AddLivroControle {

		private TelaAddLivro tela;
		
		public AddLivroControle(TelaAddLivro tela, LivroDados livroDados) throws SQLException {
			this.tela =  tela;
			tela.getSalvar().addActionListener((ActionEvent e)-> {
				String nome = tela.getTnome().getText();
				
				
				try {
					livroDados.insere(nome);;
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Desculpa, mas este livro ja está cadastrado.", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);
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


