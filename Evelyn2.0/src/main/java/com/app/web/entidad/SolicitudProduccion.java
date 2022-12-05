/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "solicitudesProduccion")
public class SolicitudProduccion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_solicitud;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_user_fk")
    Usuario id_user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_inventario_fk")
    Inventario id_inventario;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "fecha")
    private Date fecha;
    
    //Relación muchos a muchos con Produccion
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "listaSolicitudes")
    private List<Produccion> listaProducciones;

    public SolicitudProduccion() {
    }

    public SolicitudProduccion(long id_solicitud, Usuario id_user, Inventario id_inventario, String descripcion, int cantidad, Date fecha, List<Produccion> listaProducciones) {
        this.id_solicitud = id_solicitud;
        this.id_user = id_user;
        this.id_inventario = id_inventario;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.listaProducciones = listaProducciones;
    }

    public long getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(long id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Usuario getId_user() {
        return id_user;
    }

    public void setId_user(Usuario id_user) {
        this.id_user = id_user;
    }

    public Inventario getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(Inventario id_inventario) {
        this.id_inventario = id_inventario;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Produccion> getListaProducciones() {
        return listaProducciones;
    }

    public void setListaProducciones(List<Produccion> listaProducciones) {
        this.listaProducciones = listaProducciones;
    }

    @Override
    public String toString() {
        return "SolicitudProduccion{" + "id_solicitud=" + id_solicitud + ", id_user=" + id_user + ", id_inventario=" + id_inventario + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", fecha=" + fecha + ", listaProducciones=" + listaProducciones + '}';
    }
    
   
    
    

}
