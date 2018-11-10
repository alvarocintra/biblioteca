package br.up.edu.arquitetura.biblioteca.model.persistencia;


import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.model.negocio.LivroNegocio;
import br.up.edu.arquitetura.biblioteca.model.negocio.MutuarioNegocio;

public class EmprestimoPersistencia {
	
	private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		
	public Emprestimo insert(Emprestimo emp) {				
		emprestimos.add(emp);
		return emprestimos.get(emp.getId());
	}

	public ArrayList<Emprestimo> list() {
		return emprestimos;
	}

	public Emprestimo find(int id) {		
		return emprestimos.get(id);	
	}

	public Emprestimo update(Emprestimo emprestimo) {	
		return emprestimo;
	}
}
