package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;
import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.negocio.AutorNegocio;


public class LivroPersistencia {
	
	private static ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public Livro insert(Livro livro) {		  
 	  livros.add(livro);
 	  return livros.get(livro.getId());
	}
	
	public ArrayList<Livro> list(){
		return livros;
	}
	
	public Livro find (int id) {
		return livros.get(id);
	}
	
	public Livro update (Livro livro) {		
		return livro;
	}
	
	

}
