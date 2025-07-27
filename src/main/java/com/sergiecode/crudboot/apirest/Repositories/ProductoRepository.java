package com.sergiecode.crudboot.apirest.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sergiecode.crudboot.apirest.Entities.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>   {
    // No es necesario agregar métodos adicionales, JpaRepository ya proporciona
    // métodos CRUD básicos como save, findById, findAll, deleteById, etc.
    // Puedes agregar métodos personalizados si es necesario, por ejemplo:
    // List<Producto> findByNombre(String nombre);  
    // Aquí podrías definir métodos adicionales si necesitas consultas específicas
    // o personalizadas, pero para operaciones CRUD básicas, no es necesario.
    


}
