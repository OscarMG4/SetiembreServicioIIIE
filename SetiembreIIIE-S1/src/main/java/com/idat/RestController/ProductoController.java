package com.idat.RestController;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Model.Producto;
import com.idat.Repository.ProductoRepository;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Producto>> obtenerProductos(){
		return new ResponseEntity<List<Producto>>(repository.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id){
		return new ResponseEntity<Producto>(repository.obtener(id), HttpStatus.OK);
	}
	
	@PostMapping
	public void guardar(Producto producto) {
		repository.guardar(producto);
	}
	
	@PutMapping
	public void actualizar(Producto producto) {
		repository.actualizar(producto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		repository.eliminar(id);
	}
	
}
