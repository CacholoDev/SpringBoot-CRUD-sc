package com.sergiecode.crudboot.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Genera getters, setters, toString, equals, hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los campos
@Builder // Permite usar el patrón builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String nombre;
    private String precio;



}
