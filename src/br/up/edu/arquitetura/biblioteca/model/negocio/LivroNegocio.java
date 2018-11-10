package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.up.edu.arquitetura.biblioteca.model.dominio.Autor;
import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.persistencia.LivroPersistencia;


public class LivroNegocio {
	
	private LivroPersistencia persist = new LivroPersistencia();
	
	private AutorNegocio autorBC = new AutorNegocio();
	
    public void load() {
        autorBC.load();
        Autor jv = autorBC.find("Julio Verne").get(0);	
        Autor jrrt = autorBC.find("J.R.R Tolkien").get(1);
        salvar(new Livro("Viagem ao Centro da Terra", 200, "A história de jovens que viajam ao centro da terra.", jv));
        salvar(new Livro("A Volta ao Mundo em 80 dias", 320, "Uma competição ao redor do mundo", jv));
        salvar(new Livro("O Hobbit", 295, "Pequenos seres de pés peludos ajudando anões a enfrentar um dragão.", jrrt));
        salvar(new Livro("O Senhor dos Anéis", 1200, "Uma jornada épica contra o mal.", jrrt));

    }

	
	public ArrayList<Livro> listarTodos(){
		return persist.list();
	}
	
	public Livro cadastrar (Livro livro) {
		salvar(livro);		
		return livro;
	}
	   
    public Livro salvar(Livro livro) {
    	livro.setAutor(autorBC.find("").get(livro.getAutor().getId()));
    	return persist.insert(livro);    	
    }
    
    public void validaLivro(Livro livro) {
   	  if (livro.getId() != 0) {
   		 persist.list().remove(livro.getId());
   		 persist.find(livro.getId());
   		 persist.insert(livro);   		  
      } else {
       	  livro.setId(persist.list().size());	
      }
    }
    
    public Livro editar(Livro livro) {
    	Livro aux = persist.list().get(livro.getId());
		aux.setId(livro.getId());
		aux.setAutor(livro.getAutor());
		aux.setPaginas(livro.getPaginas());
		aux.setResumo(livro.getResumo());
		aux.setTitulo(livro.getTitulo());
    	return persist.update(aux);
    }
    
	public List<Livro> find(String query) {
		return persist.list();
	}


}
