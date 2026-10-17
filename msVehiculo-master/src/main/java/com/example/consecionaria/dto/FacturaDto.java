package com.example.consecionaria.dto;

public class FacturaDto {

    private Integer idFactura;
    private String nombre;
    private String correo;
    private String metodoPago;
    private int telefono; // Cambiado de String a int
    private FacturaEstadoEnum estado;
    private VehiculoDto vehiculoDto;

    public FacturaDto() {
    }

    public FacturaDto(Integer idFactura, String nombre, String correo, String metodoPago, int telefono, FacturaEstadoEnum estado, VehiculoDto vehiculoDto) {
        this.idFactura = idFactura;
        this.nombre = nombre;
        this.correo = correo;
        this.metodoPago = metodoPago;
        this.telefono = telefono;
        this.estado = estado;
        this.vehiculoDto = vehiculoDto;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public FacturaEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(FacturaEstadoEnum estado) {
        this.estado = estado;
    }

    public VehiculoDto getVehiculoDto() {
        return vehiculoDto;
    }

    public void setVehiculoDto(VehiculoDto vehiculoDto) {
        this.vehiculoDto = vehiculoDto;
    }
}