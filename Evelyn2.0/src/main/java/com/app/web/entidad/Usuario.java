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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")

public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "documento")
    private long documento;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_rol_fk")
    Rol id_rol;

    @Column(name = "contraseña")
    private String contraseña;
    
    //Relación con SolicitudProduccion
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "id_user")
    List<SolicitudProduccion> listaSolicitudes;
    
    //Relación con Entrada
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "id_user")
    List<Entrada> listaEntradas;

    public Usuario() {
    }

    public Usuario(long id_user, String nombre, String apellido, String tipo_documento, long documento, String email, String telefono, Rol id_rol, String contraseña, List<SolicitudProduccion> listaSolicitudes, List<Entrada> listaEntradas) {
        this.id_user = id_user;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.email = email;
        this.telefono = telefono;
        this.id_rol = id_rol;
        this.contraseña = contraseña;
        this.listaSolicitudes = listaSolicitudes;
        this.listaEntradas = listaEntradas;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getId_rol() {
        return id_rol;
    }

    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<SolicitudProduccion> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudProduccion> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_user=" + id_user + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_documento=" + tipo_documento + ", documento=" + documento + ", email=" + email + ", telefono=" + telefono + ", id_rol=" + id_rol + ", contrase\u00f1a=" + contraseña + ", listaSolicitudes=" + listaSolicitudes + ", listaEntradas=" + listaEntradas + '}';
    }

   
    
}
