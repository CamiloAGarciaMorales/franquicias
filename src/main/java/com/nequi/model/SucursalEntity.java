package com.nequi.model;




public class SucursalEntity {


    private Long id;

    private String nombre;
    private String direccion;


    private FranquiciaEntity franquicia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public FranquiciaEntity getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(FranquiciaEntity franquicia) {
        this.franquicia = franquicia;
    }
}
