package com.example.demo.dto;

public class SolicitudVehiculoDto {

    private int idSolicitud;
    private VehiculoDto vehiculoDto;
    private SucursalDto sucursal;
    private EstadoEnum estado;

    public SolicitudVehiculoDto() {
    }

    public SolicitudVehiculoDto(int idSolicitud, VehiculoDto vehiculoDto, SucursalDto sucursal, EstadoEnum estado) {
        this.idSolicitud = idSolicitud;
        this.vehiculoDto = vehiculoDto;
        this.sucursal = sucursal;
        this.estado = estado;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public VehiculoDto getVehiculoDto() {
        return vehiculoDto;
    }

    public void setVehiculoDto(VehiculoDto vehiculoDto) {
        this.vehiculoDto = vehiculoDto;
    }

    public SucursalDto getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDto sucursal) {
        this.sucursal = sucursal;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }
}