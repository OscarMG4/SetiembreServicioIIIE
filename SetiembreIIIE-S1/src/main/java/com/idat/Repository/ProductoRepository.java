package com.idat.Repository;

import java.util.List;

import com.idat.Model.Producto;

public interface ProductoRepository {

	void guardar(Producto producto);

	void actualizar(Producto producto);

	void eliminar(int id);

	List<Producto> listar();

	Producto obtener(int id);

}
