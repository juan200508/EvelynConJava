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
@Table(name = "rol")

public class Rol implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rol;

    @Column(name = "rol")
    private String rol;

    //Relación con Usuario
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id_rol")
    List<Usuario> listaUsuarios;

    public Rol() {
    }

    public Rol(long id_rol, String rol, List<Usuario> listaUsuarios) {
        this.id_rol = id_rol;
        this.rol = rol;
        this.listaUsuarios = listaUsuarios;
    }

    public long getId_rol() {
        return id_rol;
    }

    public void setId_rol(long id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public String toString() {
        return "Rol{" + "id_rol=" + id_rol + ", rol=" + rol + ", listaUsuarios=" + listaUsuarios + '}';
    }

}
