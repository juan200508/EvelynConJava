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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producciones")
public class Produccion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_produccion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_producto_fk")
    private Producto id_producto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "genero")
    private String genero;

    @Column(name = "talla")
    private String talla;

    @Column(name = "color")
    private String color;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private double precio;

    @Column(name = "fecha")
    private Date fecha;

    //Relación muchos a muchos con SolicitudProduccion
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ficha_solicitudes",
            joinColumns = @JoinColumn(name = "id_produccion_fk"),
            inverseJoinColumns  = @JoinColumn(name = "id_solicitud_fk")
            )
    private List<SolicitudProduccion> listaSolicitudes;

    public Produccion() {
    }

    public Produccion(long id_produccion, Producto id_producto, String descripcion, String genero, String talla, String color, int cantidad, double precio, Date fecha, List<SolicitudProduccion> listaSolicitudes) {
        this.id_produccion = id_produccion;
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.genero = genero;
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.listaSolicitudes = listaSolicitudes;
    }

    public long getId_produccion() {
        return id_produccion;
    }

    public void setId_produccion(long id_produccion) {
        this.id_produccion = id_produccion;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<SolicitudProduccion> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudProduccion> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    @Override
    public String toString() {
        return "Produccion{" + "id_produccion=" + id_produccion + ", id_producto=" + id_producto + ", descripcion=" + descripcion + ", genero=" + genero + ", talla=" + talla + ", color=" + color + ", cantidad=" + cantidad + ", precio=" + precio + ", fecha=" + fecha + ", listaSolicitudes=" + listaSolicitudes + '}';
    }

        
   
}
