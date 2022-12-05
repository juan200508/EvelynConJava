
package com.app.web.repositorio;

import com.app.web.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
    
}
