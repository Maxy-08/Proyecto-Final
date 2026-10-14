package com.example.consecionaria.dto;

import java.io.Serializable;
import java.util.List;

public class PaginadoDto<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> contenido;
    private long totalElementos;
    private int totalPaginas;
    private int tamanoPagina;
    private int numeroPagina;

    public PaginadoDto() {
    }

    public PaginadoDto(List<T> contenido, long totalElementos, int totalPaginas, int tamanoPagina, int numeroPagina) {
        this.contenido = contenido;
        this.totalElementos = totalElementos;
        this.totalPaginas = totalPaginas;
        this.tamanoPagina = tamanoPagina;
        this.numeroPagina = numeroPagina;
    }

    public List<T> getContenido() {
        return contenido;
    }

    public void setContenido(List<T> contenido) {
        this.contenido = contenido;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getTamanoPagina() {
        return tamanoPagina;
    }

    public void setTamanoPagina(int tamanoPagina) {
        this.tamanoPagina = tamanoPagina;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }
}