package com.company.Juego;

public class Jugador {

    private final String nombre;
    private final Integer probabilidadDeGanar;
    private Integer puntos;
    private Integer puntoDeQuiebre;
    private Integer sets;

    public Jugador(String nombre, Integer probabilidadDeGanar) {
        this.nombre = nombre;
        this.probabilidadDeGanar = probabilidadDeGanar;
        this.puntos = 0;
        this.puntoDeQuiebre = 0;
        this.sets = 0;
    }

    public void setPuntoDeQuiebre(Integer puntoDeQuiebre) {
        this.puntoDeQuiebre = puntoDeQuiebre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getProbabilidadDeGanar() {
        return probabilidadDeGanar;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public Integer getPuntoDeQuiebre() {
        return puntoDeQuiebre;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public void resetearPuntos() {
        this.puntos = 0;
        this.puntoDeQuiebre = 0;
    }




}
