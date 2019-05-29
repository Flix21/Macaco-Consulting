package com.macaco;

public abstract class Monstruo {
    public String nombre_monstruo ="";
    public int ataque_monstruo;
    public int defensa_monstruo;
    public int velocidad_monstruo;
    public int puntos_salud_monstruo;

    public String getNombre_monstruo() {
        return nombre_monstruo;
    }

    public void setNombre_monstruo(String nombre_monstruo) {
        this.nombre_monstruo = nombre_monstruo;
    }

    public int getAtaque_monstruo() {
        return ataque_monstruo;
    }

    public void setAtaque_monstruo(int ataque_monstruo) {
        this.ataque_monstruo = ataque_monstruo;
    }

    public int getDefensa_monstruo() {
        return defensa_monstruo;
    }

    public void setDefensa_monstruo(int defensa_monstruo) {
        this.defensa_monstruo = defensa_monstruo;
    }

    public int getVelocidad_monstruo() {
        return velocidad_monstruo;
    }

    public void setVelocidad_monstruo(int velocidad_monstruo) {
        this.velocidad_monstruo = velocidad_monstruo;
    }

    public int getPuntos_salud_monstruo() {
        return puntos_salud_monstruo;
    }

    public void setPuntos_salud_monstruo(int puntos_salud_monstruo) {
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