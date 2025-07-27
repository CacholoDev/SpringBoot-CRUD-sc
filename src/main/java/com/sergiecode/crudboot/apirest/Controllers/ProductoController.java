package com.sergiecode.crudboot.apirest.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
import com.sergiecode.crudboot.apirest.Entities.Producto;   
import com.sergiecode.crudboot.apirest.Repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        return ResponseEntity.ok(productos);    
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

  
}


/*
  @GetMapping("/{id}")
public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
    Optional<Producto> producto = productoRepository.findById(id);

    return producto
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
}
Si el Optional tiene un producto, envuélvelo en un ResponseEntity.ok(...).
 */