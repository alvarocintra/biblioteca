package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;
import br.up.edu.arquitetura.biblioteca.model.dominio.Autor;

public class AutorPersistencia  {
	
	private static ArrayList<Autor> autores = new ArrayList<Autor>();
	
	public Autor insert(Autor autor) {
		
		autor.setId(autores.size());
		autores.add(autor);
		
		return autor;
	}

	public ArrayList<Autor> list() {
		
		return autores;
	}

	public Autor find(int id) {
		
		return autores.get(id);	}

	public Autor update(Autor autor) {
		return autor;
	}
	
	

	
}
