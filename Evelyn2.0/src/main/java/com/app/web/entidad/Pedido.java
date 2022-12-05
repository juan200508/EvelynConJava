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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pedido_fk;

    @Column(name = "id_user_fk")
    private int id_user_fk;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private Date fecha;

    //Relación con Detalle pedido
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "id_pedido")
    List<DetallePedido> listaDetalles;

    public Pedido() {
    }

    public Pedido(long id_pedido_fk, int id_user_fk, String estado, Date fecha, List<DetallePedido> listaDetalles) {
        this.id_pedido_fk = id_pedido_fk;
        this.id_user_fk = id_user_fk;
        this.estado = estado;
        this.fecha = fecha;
        this.listaDetalles = listaDetalles;
    }

    public long getId_pedido_fk() {
        return id_pedido_fk;
    }

    public void setId_pedido_fk(long id_pedido_fk) {
        this.id_pedido_fk = id_pedido_fk;
    }

    public int getId_user_fk() {
        return id_user_fk;
    }

    public void setId_user_fk(int id_user_fk) {
        this.id_user_fk = id_user_fk;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetallePedido> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetallePedido> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido_fk=" + id_pedido_fk + ", id_user_fk=" + id_user_fk + ", estado=" + estado + ", fecha=" + fecha + ", listaDetalles=" + listaDetalles + '}';
    }
    

}
