package com.macaco;

public class Ranking {

    public String nombre;
    public String av_partida;
    public String fecha;
    public String tiempo;
    public String monstruo;
    public String ataque;
    public String defensa;
    public String velocidad;
    public String vida;

    public Ranking(String nombre, String av_partida, String fecha, String tiempo, String monstruo, String ataque, String defensa, String velocidad, String vida) {
        this.nombre = nombre;
        this.av_partida = av_partida;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.monstruo = monstruo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.vida = vida;
    }
}
