package com.macaco;

public class Personaje extends Entidad
{
    public Personaje()
    {
    }

    public Personaje(String nombre, int ataque, int defensa, int velocidad, int puntos_salud)
    {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.salud = puntos_salud;
    }
}

