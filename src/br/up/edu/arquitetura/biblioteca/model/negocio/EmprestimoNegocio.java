package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.model.persistencia.EmprestimoPersistencia;

public class EmprestimoNegocio  {
	
	private EmprestimoPersistencia persist = new EmprestimoPersistencia();
	
	private LivroNegocio ln = new LivroNegocio();
	
	private MutuarioNegocio mn = new MutuarioNegocio();	

	
	public void load() {
		listarTodos();		
	}
	
	public Emprestimo salvar(Emprestimo emprestimo) {
		
		validaEmprestimo(emprestimo);
		
		emprestimo.setLivro(ln.listarTodos().get(emprestimo.getLivro().getId()));
		emprestimo.setMutuario(mn.listarTodos().get(emprestimo.getMutuario().getId()));
		emprestimo.setEmprestado(true);
		
		return persist.insert(emprestimo);		
	}
	
	public void validaEmprestimo(Emprestimo emp) {
		if (emp.getId() != 0) {
			persist.list().remove(emp.getId());
			persist.find(emp.getId());
			persist.insert(emp);
		} else {
			emp.setId(persist.list().size());
		}
	}
	
	public Emprestimo editar(Emprestimo emprestimo) {
		Emprestimo aux = persist.list().get(emprestimo.getId());
		
		aux.setId(emprestimo.getId());
		aux.setLivro(emprestimo.getLivro());
		aux.setMutuario(emprestimo.getMutuario());
		aux.setDataDevolucao(emprestimo.getDataDevolucao());
		aux.setDataEmprestimo(emprestimo.getDataEmprestimo());
		aux.setDataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao());
		aux.setEmprestado(emprestimo.isEmprestado());		
		
		return persist.update(aux);
	}

	public List<Emprestimo> listar() {
		return persist.list();
	}

	public List<Emprestimo> find(String query) {
		return persist.list();
	}
	
	public ArrayList<Emprestimo> listarTodos(){
		return persist.list();
	}
}
