package com.mhdeveloper.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	private List<Categoria> categoriasPai;
	
	public CadastroProdutoBean() {
		this.produto = new Produto();
	}
	
	public void inicializar() {
		System.out.println("Inicializando...");
		
		categoriasPai = repository.buscarCategoriasPai();
	}
	
	public void salvar() {
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Categoria> getCategoriasPai() {
		return categoriasPai;
	}
}
