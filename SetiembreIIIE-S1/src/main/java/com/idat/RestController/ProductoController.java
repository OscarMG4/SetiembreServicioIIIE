package com.idat.RestController;

import java.util.List;  


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.idat.Model.Producto;
import com.idat.Service.ProductoServiceImp;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoServiceImp repo;
	
	@RequestMapping(path = "/listProduct", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> list(){
        return new ResponseEntity<List<Producto>>(repo.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/list/{id}", method = RequestMethod.GET)
    public ResponseEntity<Producto> search(int id){
        Producto productExist = repo.obtener(id);
        if (productExist != null){
            return new ResponseEntity<Producto>(repo.obtener(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/saveProduct", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Producto producto){
        repo.guardar(producto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/updateProduct", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Producto producto){
        repo.actualizar(producto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id){
    	Producto productExist = repo.obtener(id);

        if (productExist != null){
            repo.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
	
}
