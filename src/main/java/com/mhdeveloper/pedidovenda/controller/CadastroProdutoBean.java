package com.mhdeveloper.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.mhdeveloper.pedidovenda.model.Categoria;
import com.mhdeveloper.pedidovenda.model.Produto;
import com.mhdeveloper.pedidovenda.repository.CategoriaRepository;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository repository;

	private Produto produto;
	private Categoria categoriaPai;

	private List<Categoria> categorias;
	
	public CadastroProdutoBean() {
		this.produto = new Produto();
	}
	
	public void inicializar() {
		System.out.println("Inicializando...");
		
		categorias = repository.buscarCategorias();
	}
	
	public void salvar() {
		System.out.println("Categoria pai selecionada: " + categoriaPai.getDescricao());
	}

	public Produto getProduto() {
		return produto;
	}
	
	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
}
