package com.mhdeveloper.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.mhdeveloper.pedidovenda.model.Categoria;
import com.mhdeveloper.pedidovenda.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	private Produto produto;
	
	private List<Categoria> categoriasPai;
	
	public CadastroProdutoBean() {
		this.produto = new Produto();
	}
	
	public void inicializar() {
		System.out.println("Inicializando...");
		
		categoriasPai = manager.createQuery("from Categoria", Categoria.class).getResultList();
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
