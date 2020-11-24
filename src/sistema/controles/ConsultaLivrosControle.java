package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import sistema.dados.LivroDados;
import sistema.modelos.Livro;
import sistema.telas.TelaConsultaLivro;

/**
 * Classe responsável por adicionar comportamentos na tela e fazer sua lógica.
 * 
 * Faz uso de um ou mais objetos tela, que deve expor os principais componentes
 * de tela.
 * 
 * Faz uso de um ou mais objetos dados, para recuperar informações nos cliques
 * de botão, e oara atualizar a tela, etc.
 * 
 * Todas esses objetos que são dependencias para esse controle funcionar devem
 * ser passados no construtor do objeto.
 * 
 * Esta classe controle deve lidar com telas, dados, modelos e outros controles,
 * para fazer efetivamente a "cola" desses componentes.
 * 
 * @author Emerson C. Lima
 *
 */
public class ConsultaLivrosControle {

	private TelaConsultaLivro tela;

	public ConsultaLivrosControle(TelaConsultaLivro tela, LivroDados dados) throws SQLException {
		this.tela = tela;
		tela.getTable().setModel(new LivroTableModel(new ArrayList<>()));

		tela.getBtnPesquisar().addActionListener((ActionEvent e) -> {
			try {
				List<Livro> livros=dados.todos();
				tela.getTable().setModel(new LivroTableModel(livros));
				if (tela.getTxtPesquisa().getText().trim().isEmpty()
						&& tela.getCheckBoxValida().isSelected() == false) {
					TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tela.getTable().getModel());
					tela.getTable().setRowSorter(rowSorter);
					rowSorter.setRowFilter(null);
					
					livros = dados.todos();
				} else if (tela.getTxtPesquisa().getText().trim().isEmpty()
						&& tela.getCheckBoxValida().isSelected() == true) {
					livros=dados.todosPendentes();
					tela.getTable().setModel(new LivroTableModel(livros));
				
					TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tela.getTable().getModel());
					tela.getTable().setRowSorter(rowSorter);
					rowSorter.setRowFilter(null);
				}

				else if (!tela.getTxtPesquisa().getText().trim().isEmpty()
						&& tela.getCheckBoxValida().isSelected() == false) {
				
					TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tela.getTable().getModel());
					tela.getTable().setRowSorter(rowSorter);
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tela.getTxtPesquisa().getText()));
				} 
				else if (!tela.getTxtPesquisa().getText().trim().isEmpty()
						&& tela.getCheckBoxValida().isSelected() == true){
					livros=dados.todosPendentes();
					tela.getTable().setModel(new LivroTableModel(livros));
					TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tela.getTable().getModel());
					tela.getTable().setRowSorter(rowSorter);
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tela.getTxtPesquisa().getText()));
				}

				
			} catch (Exception err) {
				JOptionPane.showMessageDialog(null, err.getMessage());
			}
		});

	}

	public void mostra() {
		this.tela.setVisible(true);
	}
}

/**
 * Classe responsável por mapear uma lista de livros nos valores das células
 * do JTable.
 * 
 * @author Emerson C. Lima
 */
class LivroTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Livro> livros;

	public LivroTableModel(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
	
		default:
			return null;
		}
	}

	@Override
	public int getRowCount() {
		return livros.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Livro a = livros.get(linha);
		switch (coluna) {
		case 0:
			return a.getId();
		case 1:
			return a.getNome();
		
		default:
			return null;
		}
	}
}