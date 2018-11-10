package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;

public class MutuarioPersistencia {
	
	private static ArrayList<Mutuario> mutuarios = new ArrayList<Mutuario>();

	public Mutuario insert(Mutuario mutuario) {
		
		mutuario.setId(mutuarios.size());
		mutuarios.add(mutuario);
		
		return mutuarios.get(mutuario.getId());
	}

	public ArrayList<Mutuario> list() {
		
		return mutuarios;
	}

	public Mutuario find(int id) {
		
		return mutuarios.get(id);	}

	public Mutuario update(Mutuario mutuario) {		
		return mutuario;
	}
	
	public void deletar(int id) {
		mutuarios.remove(id);
	}

}
