/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.controlador;

import com.app.web.entidad.Producto;
import com.app.web.repositorio.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepositorio productorepositorio;

    @GetMapping("/inventario/producto")
    public String lisatrProducto(Model modelo) {
        List<Producto> listaProductos = productorepositorio.findAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "productos";
    }

    @GetMapping("/inventario/producto/nuevo")
    public String mostrarFormularioCrear(Model modelo) {
        modelo.addAttribute("producto", new Producto());
        return "producto-nuevo";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {
        productorepositorio.save(producto);
        return "redirect:/inventario/producto";
    }

}
