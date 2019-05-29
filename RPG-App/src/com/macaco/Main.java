package com.macaco;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)  throws InterruptedException /*Excepción necesaria para calcular el tiempo*/
    {
        //Para saber el tiempo de juego (SOLO AL FINAL DE LA PARTIDA)
        //System.out.println(GameTimer.getPlayTime());


        System.out.println("Bienvenido a Macaco. Dinos tu nombre");
        Scanner keyboard_nombre = new Scanner(System.in);
        Personaje personaje = new Personaje();

        personaje.nombre_personaje= keyboard_nombre.nextLine();
        System.out.println("Muy bien "+personaje.getNombre_personaje() + ", preparate para la aventura");
        int puntos=50;
        System.out.println("Tienes 50 puntos para ser distribuidos entre los atributos Ataque, Defensa y Velocidad");
        String[] atributos = {"ataque", "defensa", "velocidad"};
        Integer[] puntaje_atributos= new Integer[3];

        for (int i = 0; puntos > 0; i++){
            System.out.println("¿Cuántos puntos de los " + puntos + " quieres añadirle a " + atributos[i] + "?");
            Scanner keyboard = new Scanner(System.in);
            String puntos_agregados =keyboard.nextLine();
            if(Integer.parseInt(puntos_agregados) <= puntos)
            {
                puntos=puntos-(Integer.parseInt(puntos_agregados));
                puntaje_atributos[i]= Integer.parseInt(puntos_agregados);
            }
            else
                {
                System.out.println("Te has pasado de los 50 puntos");
                break;
            }
        }
        if(puntaje_atributos[0] != null)
        {
            personaje.ataque_personaje=puntaje_atributos[0];
        }
        if(puntaje_atributos[1] != null)
        {
            personaje.defensa_personaje=puntaje_atributos[1];
        }
        if(puntaje_atributos[2] != null)
        {
            personaje.velocidad_personaje = puntaje_atributos[2];
        }
        System.out.println("Perfecto "+personaje.nombre_personaje + ", tienes "
                + personaje.ataque_personaje + " puntos de ataque, "
                + personaje.defensa_personaje+" de defensa, "+personaje.velocidad_personaje+" de velocidad y "
                + personaje.getPuntos_salud_personaje() + " puntos de salud");
    }
}