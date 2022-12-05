/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.controlador;

import com.app.web.entidad.Producto;
import com.app.web.entidad.Proveedor;
import com.app.web.repositorio.ProveedorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {
    
    @Autowired
    private ProveedorRepositorio proveedorrepositorio;
    
    @GetMapping("/proveedores")
    public String listarProveedores(Model modelo){
        List<Proveedor> listaProveedores = proveedorrepositorio.findAll();
        modelo.addAttribute("listaProveedores", listaProveedores);
        return "proveedores";
    }
    
    @GetMapping("/proveedores/nuevo")
    public String mostrarFormNuevoProveedor(Model modelo){
        modelo.addAttribute("proveedor", new Proveedor());
        return "proveedor-nuevo";
    }
    
    @PostMapping("/proveedor/guardar")
    public String guardarProducto(Proveedor proveedor) {
        proveedorrepositorio.save(proveedor);
        return "redirect:/proveedores";
    }
}
