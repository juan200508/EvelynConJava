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
@Table(name = "inventarios")
public class Inventario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_registro;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    //Relación con Entrada
    @OneToMany(mappedBy = "id_inventario")
    List<Entrada> listaentradas;

    //Relacion con SolicitudProduccion
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_inventario")
    List<SolicitudProduccion> listaSolicitudes;

    public Inventario() {
    }

    public Inventario(long id_registro, String descripcion, int cantidad, List<Entrada> listaentradas, List<SolicitudProduccion> listaSolicitudes) {
        this.id_registro = id_registro;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.listaentradas = listaentradas;
        this.listaSolicitudes = listaSolicitudes;
    }

    public long getId_registro() {
        return id_registro;
    }

    public void setId_registro(long id_registro) {
        this.id_registro = id_registro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Entrada> getListaentradas() {
        return listaentradas;
    }

    public void setListaentradas(List<Entrada> listaentradas) {
        this.listaentradas = listaentradas;
    }

    public List<SolicitudProduccion> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudProduccion> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_registro=" + id_registro + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", listaentradas=" + listaentradas + ", listaSolicitudes=" + listaSolicitudes + '}';
    }

}
