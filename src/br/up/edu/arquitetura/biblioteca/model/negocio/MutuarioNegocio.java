package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;
import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.model.persistencia.MutuarioPersistencia;

public class MutuarioNegocio  {

	private MutuarioPersistencia persist = new MutuarioPersistencia();
	
	public void load() {
		if(persist.list().size() == 0) {
			Mutuario mutuario = new Mutuario("Fulano", "Uma rua, 666", "1234567890");
    		salvar(mutuario);
		}else {
			listarTodos();
		}
	}
	
	public Mutuario salvar(Mutuario mutuario) {				
		return persist.insert(mutuario);		
	}
	
	public Mutuario editar(Mutuario mutuario) {
		Mutuario aux = persist.list().get(mutuario.getId());
		
		aux.setId(mutuario.getId());
		aux.setNome(mutuario.getNome());
		aux.setEndereco(mutuario.getEndereco());
		aux.setTelefone(mutuario.getTelefone());
		return persist.update(aux);
	}

	public ArrayList<Mutuario> listar() {
		return persist.list();
	}

	public ArrayList<Mutuario> find(String query) {
		return persist.list();
	}
	
	public void deletar(int id) {
		persist.deletar(id);
	}
	
	public ArrayList<Mutuario> listarTodos(){
		return persist.list();
	}
	
	

}
