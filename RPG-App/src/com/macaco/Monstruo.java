package com.macaco;

public abstract class Monstruo {
    public String nombre_monstruo ="";
    public int ataque_monstruo;
    public int defensa_monstruo;
    public int velocidad_monstruo;
    public int puntos_salud_monstruo;

    public String getNombre() {
        return nombre_monstruo;
    }

    public void setNombre(String nombre_monstruo) {
        this.nombre_monstruo = nombre_monstruo;
    }

    public int getAtaque() {
        return ataque_monstruo;
    }

    public void setAtaque(int ataque_monstruo) {
        this.ataque_monstruo = ataque_monstruo;
    }

    public int getDefensa() {
        return defensa_monstruo;
    }

    public void setDefensa(int defensa_monstruo) {
        this.defensa_monstruo = defensa_monstruo;
    }

    public int getVelocidad() {
        return velocidad_monstruo;
    }

    public void setVelocidad(int velocidad_monstruo) {
        this.velocidad_monstruo = velocidad_monstruo;
    }

    public int getSalud() {
        return puntos_salud_monstruo;
    }

    public void setSalud(int puntos_salud_monstruo) {
        this.puntos_salud_monstruo = puntos_salud_monstruo;
    }
    //contructor vacio
    public Monstruo(){

    }

    public Monstruo(String nombre_monstruo, int ataque_monstruo, int defensa_monstruo, int velocidad_monstruo, int puntos_salud_monstruo) {
        this.nombre_monstruo = nombre_monstruo;
        this.ataque_monstruo = ataque_monstruo;
        this.defensa_monstruo = defensa_monstruo;
        this.velocidad_monstruo = velocidad_monstruo;
        this.puntos_salud_monstruo = puntos_salud_monstruo;
    }

    @Override
    public String toString() {
        return "Monstruo{" +
                "nombre_monstruo='" + nombre_monstruo + '\'' +
                ", ataque_monstruo=" + ataque_monstruo +
                ", defensa_monstruo=" + defensa_monstruo +
                ", velocidad_monstruo=" + velocidad_monstruo +
                ", puntos_salud_monstruo=" + puntos_salud_monstruo +
                '}';
    }
}