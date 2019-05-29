package com.macaco;



public class Personaje {

    public String nombre_personaje ="";
    public int ataque_personaje;
    public int defensa_personaje;
    public int velocidad_personaje;
    public int puntos_salud_personaje=100;



    public String getNombre() {
        return nombre_personaje;
    }

    public void setNombre(String nombre_personaje) {
        this.nombre_personaje = nombre_personaje;
    }

    public int getAtaque() {
        return ataque_personaje;
    }

    public void setAtaque(int ataque_personaje) {
        this.ataque_personaje = ataque_personaje;
    }

    public int getDefensa() {
        return defensa_personaje;
    }

    public void setDefensa(int defensa_personaje) {
        this.defensa_personaje = defensa_personaje;
    }

    public int getVelocidad() {
        return velocidad_personaje;
    }

    public void setVelocidad(int velocidad_personaje) {
        this.velocidad_personaje = velocidad_personaje;
    }

    public int getSalud() {
        return puntos_salud_personaje;
    }

    public void setSalud(int puntos_salud_personaje) {
        this.puntos_salud_personaje = puntos_salud_personaje;
    }

    //Constructor vacio
    public Personaje (){

    }

    //Constructor con todos los atributos
    public Personaje(String nombre_personaje, int ataque_personaje, int defensa_personaje, int velocidad_personaje, int puntos_salud_personaje) {
        this.nombre_personaje = nombre_personaje;
        this.ataque_personaje = ataque_personaje;
        this.defensa_personaje = defensa_personaje;
        this.velocidad_personaje = velocidad_personaje;
        this.puntos_salud_personaje = puntos_salud_personaje;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre_personaje='" + nombre_personaje + '\'' +
                ", ataque_personaje=" + ataque_personaje +
                ", defensa_personaje=" + defensa_personaje +
                ", velocidad_personaje=" + velocidad_personaje +
                ", puntos_salud_personaje=" + puntos_salud_personaje +
                '}';
    }
}