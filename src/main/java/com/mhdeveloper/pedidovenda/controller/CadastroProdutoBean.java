package com.mhdeveloper.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mhdeveloper.pedidovenda.model.Categoria;
import com.mhdeveloper.pedidovenda.model.Produto;
import com.mhdeveloper.pedidovenda.repository.CategoriaRepository;
import com.mhdeveloper.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository repository;

	private Produto produto;
	private Categoria categoriaPai;

	private List<Categoria> categorias;
	private List<Categoria> subcategorias;
	
	public CadastroProdutoBean() {
		this.produto = new Produto();
	}
	
	public void inicializar() {
		if(FacesUtil.isNotPostback()) {
			categorias = repository.buscarCategorias();
		}
	}
	
	public void carregarSubcategorias() {
		subcategorias = repository.buscarSubcategorias(categoriaPai);
	}
	
	public void salvar() {
		System.out.println("Categoria pai selecionada: " + categoriaPai.getDescricao());
		System.out.println("Subcategoria selecionada: " + produto.getCategoria().getDescricao());
	}

	public Produto getProduto() {
		return produto;
	}
	
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
}
