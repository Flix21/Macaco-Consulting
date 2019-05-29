package com.macaco;

import java.util.Scanner;

public class Main
{
    private static Personaje personaje;

    public static void main(String[] args)  throws InterruptedException /*Excepción necesaria para calcular el tiempo*/
    {
        if(personaje == null)
        {
            createPlayer();
        }
    }

    private static void endGame()
    {
        //Para saber el tiempo de juego
        //System.out.println(GameTimer.getPlayTime());
    }

    private static void createPlayer()
    {
        System.out.println("Bienvenido a Macaco. Dinos tu nombre");
        Scanner keyboard_nombre = new Scanner(System.in);
        personaje = new Personaje();

        personaje.setNombre(keyboard_nombre.nextLine());
        System.out.println("Muy bien " + personaje.getNombre() + ", preparate para la aventura");
        int puntos=50;
        System.out.println("Tienes 50 puntos para ser distribuidos entre los atributos Ataque, Defensa y Velocidad");
        String[] atributos = {"ataque", "defensa", "velocidad"};
        Integer[] puntaje_atributos= new Integer[3];

        for (int i = 0; puntos > 0; i++)
        {
            System.out.println("¿Cuántos puntos de los " + puntos + " quieres añadirle a " + atributos[i] + "?");
            Scanner keyboard = new Scanner(System.in);
            String puntos_agregados =keyboard.nextLine();
            if(Integer.parseInt(puntos_agregados) <= puntos)
            {
                puntos -= Integer.parseInt(puntos_agregados);
                puntaje_atributos[i] = Integer.parseInt(puntos_agregados);
            }
            else
            {
                System.out.println("Te has pasado de los 50 puntos");
                break;
            }
        }
        if(puntaje_atributos[0] != null)
        {
            personaje.setAtaque(puntaje_atributos[0]);
        }
        if(puntaje_atributos[1] != null)
        {
            personaje.setDefensa(puntaje_atributos[1]);
        }
        if(puntaje_atributos[2] != null)
        {
            personaje.setVelocidad(puntaje_atributos[2]);
        }
        System.out.println("Perfecto "+personaje.nombre_personaje + ", tienes "
                + personaje.ataque_personaje + " puntos de ataque, "
                + personaje.defensa_personaje+" de defensa, "+personaje.velocidad_personaje+" de velocidad y "
                + personaje.getSalud() + " puntos de salud");
    }
}