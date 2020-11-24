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

import sistema.dados.EmprestimoDados;
import sistema.modelos.Emprestimo;
import sistema.telas.TelaConsultaEmprestimo;
	

	public class ConsulEmprestimoControle {
	
	

		private TelaConsultaEmprestimo tela;
		
		public  ConsulEmprestimoControle(TelaConsultaEmprestimo tela, EmprestimoDados dados) throws SQLException {		
					this.tela = tela;
				tela.getTable().setModel(new EmprestimoTableModel(new ArrayList<>()));
				tela.getBtnPesquisar().addActionListener((ActionEvent e) -> {
					try {
						List<Emprestimo> emprestimo = dados.todos();
						
						if (tela.getTxtPesquisa().getText().trim().isEmpty() ) {
							emprestimo = dados.todos();
					
							
						}		
						else  {
							TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tela.getTable().getModel());
							tela.getTable().setRowSorter(rowSorter);
							rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + tela.getTxtPesquisa().getText()));
							
							
							
						} 
						tela.getTable().setModel(new EmprestimoTableModel(emprestimo));
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, "N„o foi possÌvel acessar o banco de dados");
					}
				});
			}
			
			public void mostra() {
				this.tela.setVisible(true);
			}
		}

		/**
		 * Classe respons√°vel por mapear uma lista de livros nos valores das c√©lulas do
		 * JTable.
		 * 
		 * @author Emerson C. Lima
		 */
		class EmprestimoTableModel extends AbstractTableModel {

			private static final long serialVersionUID = 1L;
			private List<Emprestimo> emprestimo;

			public EmprestimoTableModel(List<Emprestimo> emprestimo) {
				this.emprestimo = emprestimo;
			}
			
			@Override
			public int getColumnCount() {
				return 4;
			}

			@Override
			public String getColumnName(int column) {
				switch (column) {
					case 0: return "aluno";
					case 1: return "livro";
					case 2: return "emprestimo";
					case 3: return "prevista";
					
					default: return null;
				}
			}
			
			@Override
			public int getRowCount() {
				return emprestimo.size();
			}

			@Override
			public Object getValueAt(int linha, int collumn) {
				Emprestimo e = emprestimo.get(linha);
				switch (collumn) {
					case 0: return e.getNome();
					case 1: return e.getLivro();
					case 2: return e.getDt_emprestimo();
					case 3: return e.getDt_prevdevolucao();
					default: return null;
				}
			}
		}
	
		