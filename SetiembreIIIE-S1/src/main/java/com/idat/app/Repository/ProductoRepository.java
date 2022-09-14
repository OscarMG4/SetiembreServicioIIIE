package com.idat.app.Repository;

import java.util.List;

import com.idat.app.Model.Producto;

public interface ProductoRepository {
	
	void guardar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Integer id);
	List<Producto> listar();
	Producto obtener(Integer id);
	
}
