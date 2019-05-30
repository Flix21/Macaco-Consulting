package com.macaco;

public abstract class Entidad
{
    public String nombre ="";
    public int ataque;
    public int defensa;
    public int velocidad;
    public int salud=100;


    // constructor vacio
    public Entidad (){

    }
    //Constructor lleno
    public Entidad(String nombre, int ataque, int defensa, int velocidad, int puntos_salud) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.salud = puntos_salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int puntos_salud) {
        this.salud = puntos_salud;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "nombre='" + nombre + '\'' +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", velocidad=" + velocidad +
                ", puntos_salud=" + salud +
                '}';
    }
}
