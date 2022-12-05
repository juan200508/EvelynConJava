
package com.app.web.repositorio;

import com.app.web.entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long>
{
    
}
