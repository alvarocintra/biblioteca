package br.up.edu.arquitetura.biblioteca.model.dominio;

public class Emprestimo {
	
	private int id;
	private String dataEmprestimo;
	private String dataDevolucao;
	private String dataPrevistaDevolucao;
	private boolean emprestado;
	private Livro livro;
	private Mutuario mutuario;
	
	public Emprestimo(){}		
	
	public String getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(String dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	
	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	public Emprestimo(Livro livro, Mutuario mutuario, String dataEmprestimo, String dataDevolucao){
		this.livro=livro;
		this.mutuario=mutuario;
		this.dataDevolucao=dataDevolucao;
		this.dataEmprestimo=dataEmprestimo;		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Mutuario getMutuario() {
		return mutuario;
	}
	public void setMutuario(Mutuario mutuario) {
		this.mutuario = mutuario;
	}
}
