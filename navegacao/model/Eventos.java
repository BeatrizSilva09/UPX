package com.example.navegacao.model;

public class Eventos {
    private Long id;
    private String tituloEvento;
    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String TituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDataEvento() {
        return data;
    }

    public void setDataEvento(String data) {
        this.data = data;
    }
}
