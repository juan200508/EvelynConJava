/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_proveedor;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private double telefono;

    //Relación con DetallePedido
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="id_proveedor")
    List<DetallePedido> listaDetalles;

    public Proveedor() {
    }

    public Proveedor(long id_proveedor, String nombre, String direccion, double telefono, List<DetallePedido> listaDetalles) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaDetalles = listaDetalles;
    }

    public long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    public List<DetallePedido> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetallePedido> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", listaDetalles=" + listaDetalles + '}';
    }
  
    
    
}
