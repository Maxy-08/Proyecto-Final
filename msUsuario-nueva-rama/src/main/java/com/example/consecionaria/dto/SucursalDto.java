package com.example.consecionaria.dto;

import java.io.Serializable;

public class SucursalDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idSucursal;
    private String direccion;

    public SucursalDto() {
    }

    public SucursalDto(Integer idSucursal, String direccion) {
        this.idSucursal = idSucursal;
        this.direccion = direccion;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}