package com.app.web.entidad;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entradas")

public class Entrada implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_entrada;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_user_fk")
    private Usuario id_user;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_inventario_fk")
    private Inventario id_inventario;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_producto_fk")
    private Producto id_producto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "fecha")
    private String fecha;

    public Entrada() {
    }

    public Entrada(long id_entrada, Usuario id_user, Inventario id_inventario, Producto id_producto, String descripcion, int cantidad, String fecha) {
        this.id_entrada = id_entrada;
        this.id_user = id_user;
        this.id_inventario = id_inventario;
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public long getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(long id_entrada) {
        this.id_entrada = id_entrada;
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

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id_entrada=" + id_entrada + ", id_user=" + id_user + ", id_inventario=" + id_inventario + ", id_producto=" + id_producto + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", fecha=" + fecha + '}';
    }

   
    
    
}
