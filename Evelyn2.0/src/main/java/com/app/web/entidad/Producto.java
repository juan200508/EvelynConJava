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

/**
 *
 * @author jdpel
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;

    @Column(name = "descripcion")
    private String descripcion;
    
    //Relación con entrada
    @OneToMany(mappedBy = "id_producto")
    List<Entrada> listaentrada;
    
    //Relación con DetallePedido
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "id_producto")
    List<DetallePedido> listaDetalles;
    
    //Relación con Produccion
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "id_producto")
    List<Produccion> listaProducciones;

    public Producto() {
    }

    public Producto(long id_producto, String descripcion, List<Entrada> listaentrada, List<DetallePedido> listaDetalles, List<Produccion> listaProducciones) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.listaentrada = listaentrada;
        this.listaDetalles = listaDetalles;
        this.listaProducciones = listaProducciones;
    }

    public Producto(String tela) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Entrada> getListaentrada() {
        return listaentrada;
    }

    public void setListaentrada(List<Entrada> listaentrada) {
        this.listaentrada = listaentrada;
    }

    public List<DetallePedido> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetallePedido> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public List<Produccion> getListaProducciones() {
        return listaProducciones;
    }

    public void setListaProducciones(List<Produccion> listaProducciones) {
        this.listaProducciones = listaProducciones;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", descripcion=" + descripcion + ", listaentrada=" + listaentrada + ", listaDetalles=" + listaDetalles + ", listaProducciones=" + listaProducciones + '}';
    }
    
    
}   
