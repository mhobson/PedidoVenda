package com.mhdeveloper.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.mhdeveloper.pedidovenda.model.Categoria;
import com.mhdeveloper.pedidovenda.repository.CategoriaRepository;
import com.mhdeveloper.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	//@Inject
	private CategoriaRepository categorias;
	
	public CategoriaConverter() {
		categorias = CDIServiceLocator.getBean(CategoriaRepository.class); // Para suprir a falta de suporte do Inject
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = categorias.buscarCategoriaPorId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Categoria) value).getId().toString();
		}
		
		return "";
	}

}
