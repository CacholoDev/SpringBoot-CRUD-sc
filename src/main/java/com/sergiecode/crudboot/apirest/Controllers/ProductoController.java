package com.sergiecode.crudboot.apirest.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
import com.sergiecode.crudboot.apirest.Entities.Producto;   
import com.sergiecode.crudboot.apirest.Repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    // actualizar o eliminar productos utilizando @PutMapping y @DeleteMapping respectivamente.
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        if (!productoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        // Aquí puedes establecer el ID del producto a actualizar
        producto.setId(id);
        Producto updatedProducto = productoRepository.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }


     @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        if (!productoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
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