package com.macaco;

public class Monstruo extends Entidad
{
    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntos_salud)
    {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.salud = puntos_salud;
    }
}
