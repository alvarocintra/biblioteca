package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.up.edu.arquitetura.biblioteca.model.dominio.Autor;
import br.up.edu.arquitetura.biblioteca.model.persistencia.AutorPersistencia;

public class AutorNegocio {

	private AutorPersistencia persist = new AutorPersistencia();

	public ArrayList<Autor> listarTodos() {
		return persist.list();
	}
	
    public void load() {
        if(persist.list().size() == 0) {    
        salvar(new Autor("Julio Verne", "France"));
   	    salvar(new Autor("J.R.R Tolkien", "South Africa"));
        }else {
        	persist.list();
        }
    }	

	public Autor cadastrar(Autor autor) {
		autor = persist.insert(autor);
		return autor;
	}

	public List<Autor> find(String query) {
		return persist.list();
	}


	public Autor salvar(Autor autor) {		
		return persist.insert(autor);		
	}
	
	public Autor editar (Autor autor) {	
		Autor aux = persist.list().get(autor.getId());
		
		aux.setId(autor.getId());
		aux.setNome(autor.getNome());
		aux.setNacionalidade(autor.getNacionalidade());
		
		return persist.update(aux);
	}
	

}
