package com.example.consecionaria.entity;

import com.example.consecionaria.dto.EstadoEnum;
import com.example.consecionaria.dto.SolicitudVehiculoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitudes_vehiculo")
public class SolicitudVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitud; 

    @ManyToOne
    @JoinColumn(name = "idVehiculo") 
    private Vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "idSucursalDestino") 
    private Sucursal sucursal;
    
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado; 

    public SolicitudVehiculo() {
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public SolicitudVehiculoDto toDto() {
        SolicitudVehiculoDto dto = new SolicitudVehiculoDto();
        dto.setIdSolicitud(this.idSolicitud);
        if (this.vehiculo != null) {
            dto.setVehiculoDto(this.vehiculo.toDto());
        }
        if (this.sucursal != null) {
            dto.setSucursal(this.sucursal.toDto());
        }
        dto.setEstado(this.estado);
        return dto;
    }
}