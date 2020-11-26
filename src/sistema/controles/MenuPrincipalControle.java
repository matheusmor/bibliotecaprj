package sistema.controles;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import sistema.telas.TelaMenuPrincipal;

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
public class MenuPrincipalControle {

	TelaMenuPrincipal tela;

	public MenuPrincipalControle(TelaMenuPrincipal tela, ConsultaAlunosControle consultaAlunosControle,
			AddAlunoControle addAlunocontrole, AddLivroControle addLivroControle, ConsultaLivrosControle consultaLivroControle,
			ConsulEmprestimoControle consulEmpControle, RealizarEmprestimoControle realizaEmprestimoControle, RealizarDevolucaoControle realizaDevolucaoControle) {
		this.tela = tela;

		this.tela.getSair().addActionListener((ActionEvent e) -> {
			for (Frame f : Frame.getFrames()) {
				f.dispose();
			}
		});

		this.tela.getConsultarAlunos().addActionListener((ActionEvent e) -> {
			consultaAlunosControle.mostra();
		});
		this.tela.getAddAluno().addActionListener((ActionEvent e) -> {

			addAlunocontrole.mostra();

		});
		this.tela.getMnuAdicionarLivros().addActionListener((ActionEvent e) -> {

			addLivroControle.mostra();

		});

		this.tela.getMnuConsultarLivros().addActionListener((ActionEvent e) -> {
			
			consultaLivroControle.mostra();
	});
		this.tela.getMnuConsultarEmpDev().addActionListener((ActionEvent e) -> {
			
			consulEmpControle.mostra();
	});
	
	this.tela.getMnuRealizarEmprestimo().addActionListener((ActionEvent e) -> {
			
		realizaEmprestimoControle.mostra();
	});
	this.tela.getMnuRealizarDevolucao().addActionListener((ActionEvent e) ->{
		
		realizaDevolucaoControle.mostra();
		
	});
		
		
		
	}

	public void mostra() {
		this.tela.setVisible(true);
	}

}
