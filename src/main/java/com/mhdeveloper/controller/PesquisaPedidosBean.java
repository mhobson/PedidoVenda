package com.mhdeveloper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PesquisaPedidosBean {
	
	private List<Integer> pedidosFiltrados;
	
	public PesquisaPedidosBean() {
		pedidosFiltrados = new ArrayList<Integer>();
		for (int i = 1; i <= 50; i++) {
			pedidosFiltrados.add(i);
		}
	}
	
	public List<Integer> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

}
