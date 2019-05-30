package com.macaco;

        import java.util.*;

public class Main
{
    private static Personaje personaje;

    private enum path { NONE, CASTILLO, BOSQUE, CUEVA };
    private static path camino;
    private static List<String> enemy, estancia;

    public static void main(String[] args)  throws InterruptedException /*Excepción necesaria para calcular el tiempo*/
    {
        if(personaje == null)
        {
            createPlayer();
        }
        choosePath();

    }

    private static void choosePath()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(personaje.getNombre() + ", ha estado vagando por la ruta comercial mucho tiempo sin destino.\n" +
                "Tras meses de viaje se encuentra con un poblado, es momento de empezar una nueva vida y\n" +
                "busca el gremio más popular para emprender su primera aventura y hacerse conocer como\n" +
                " un caballero honorable y honrado.\n\n" +
                "En el tablón del gremio se encuentra con tres carteles de misiones que aún no han sido asignadas:\n" +
                "[1] CASTILLO ENCANTADO     [2] BOSQUE MALDITO      [3] CUEVA TENEBROSA");
        switch (keyboard.nextInt())
        {
            case 1:
                camino = path.CASTILLO;
                break;
            case 2:
                camino = path.BOSQUE;
                break;
            case 3:
                camino = path.CUEVA;
                break;
            default:
                camino = path.NONE;
                break;
        }
        switch (camino)
        {
            case CASTILLO:
                enemy  = Arrays.asList("VAMPIRO", "CABALLERO HUECO", "FANTASMA", "ESQUELETO");
                estancia  = Arrays.asList("PASILLO", "SALÓN", "PATIO", "TORRE", "MAZMORRA");
                break;
            case BOSQUE:
                enemy  = Arrays.asList("GOBLIN", "TROLL", "FANTASMA", "LICÁNTROPO");
                estancia  = Arrays.asList("CIÉNAGA", "CLARO", "ESPESURA", "SANTUARIO");
                break;
            case CUEVA:
                enemy  = Arrays.asList("GOBLIN", "TROLL", "OSO SALVAJE", "ESQUELETO");
                estancia  = Arrays.asList("ENTRADA", "GALERÍA", "GALERÍA OSCURA", "GALERÍA DE LA LUNA");
                break;
        }

        System.out.println("Arrancas el trozo de pergamino del tablón y en él ves una advertencia:");
        System.out.println("Éstos son los enemigos con los que te puedes encontrar");

        for (int i = 0; i < enemy.size(); i++)
        {
            if(i < 3)
                System.out.print(enemy.get(i) + ", ");
            else
                System.out.print(enemy.get(i));
        }
    }

    private static void endGame()
    {
        //Para saber el tiempo de juego
        //System.out.println(GameTimer.getPlayTime());
    }

    private static Personaje createPlayer()
    {
        System.out.println("Bienvenido a Macaco. Dinos tu nombre...");
        Scanner keyboard_nombre = new Scanner(System.in);
        personaje = new Personaje();

        personaje.setNombre(keyboard_nombre.nextLine());
        System.out.println("Muy bien " + personaje.getNombre() + ", ¡prepárate para la aventura!");
        int puntos=50;
        System.out.println("Tienes 50 puntos para ser distribuidos entre los atributos Ataque, Defensa y Velocidad");
        String[] atributos = {"ataque", "defensa", "velocidad"};
        Integer[] puntaje_atributos= new Integer[3];

        for (int i = 0; puntos > 0; i++)
        {
            System.out.println("¿Cuántos puntos de los " + puntos + " quieres añadirle a " + atributos[i] + "?");
            Scanner keyboard = new Scanner(System.in);
            String puntos_agregados = keyboard.nextLine();
            if(Integer.parseInt(puntos_agregados) <= puntos)
            {
                puntos -= Integer.parseInt(puntos_agregados);
                puntaje_atributos[i] = Integer.parseInt(puntos_agregados);
            }
            else
            {
                System.out.println("Te has pasado de los 50 puntos, no eres digno para jugar Macaco...");
                System.exit(10);
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
        System.out.println("Perfecto " + personaje.getNombre() + ", tienes "
                + personaje.getAtaque() + " puntos de ataque, "
                + personaje.getDefensa()+" de defensa, "+personaje.getVelocidad()+" de velocidad y "
                + personaje.getSalud() + " puntos de salud");
        return personaje;
    }

}