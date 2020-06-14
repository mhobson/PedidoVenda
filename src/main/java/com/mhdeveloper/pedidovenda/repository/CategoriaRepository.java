package com.mhdeveloper.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.mhdeveloper.pedidovenda.model.Categoria;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Categoria> buscarCategoriasPai() {
		return manager.createQuery("from Categoria", Categoria.class).getResultList();
	}

}
