package com.macaco;
import java.util.Random;
import java.util.Scanner;

public class Combate {

    //Declaración de variables
    private int PlayerHP,PlayerAD,PlayerDP,PlayerSpeed,
            MonsterHP, MonsterAD, MonsterDP, MonsterSpeed;
    private String PlayerName, MonsterName;
    private boolean fin=false;
    private int accionP=0,accionM=0;
    Random random=new Random();

    //Constructor
    public Combate(Personaje Personaje, Monstruo Monstruo)
    {
        PlayerHP = Personaje.getSalud();
        PlayerAD = Personaje.getAtaque();
        PlayerDP = Personaje.getDefensa();
        PlayerSpeed = Personaje.getVelocidad();
        PlayerName = Personaje.getNombre();
        MonsterAD = Monstruo.getAtaque();
        MonsterDP = Monstruo.getDefensa();
        MonsterHP = Monstruo.getSalud();
        MonsterSpeed = Monstruo.getVelocidad();
        MonsterName = Monstruo.getNombre();
    }

    @Override
    public String toString()
    {
        return "\n\nCOMBATE ENTRE "+ PlayerName+" y "+ MonsterName+"\n"+
                "Éstas son las estadísticas de "+PlayerName+":\n"+
                "Player HP= " + PlayerHP +
                "\nPlayer AD=" + PlayerAD +
                "\nPlayer DP=" + PlayerDP +
                "\nPlayer Speed=" + PlayerSpeed +
                "\n\nÉstas son las estadísticas de "+MonsterName+":\n"+
                "\nMonsterHP=" + MonsterHP +
                "\nMonsterAD=" + MonsterAD +
                "\nMonsterDP=" + MonsterDP +
                "\nMonsterSpeed=" + MonsterSpeed;
    }


    //MÉTODO PRINCIPAL

    public Entidad doCombate ()
    {

        //Saco por pantalla la situacion del combate
        System.out.println(toString());
        Scanner keyboard = new Scanner(System.in);

        while (!fin)
        {
            //Reseteo las acciones
            accionP = 0;
            accionM = 0;
            System.out.println("\n\nTu vida actual: "+PlayerHP+"\nVida de " + MonsterName + ": " +
                    MonsterHP + "\n\n¿Qué deseas hacer?\n1:Atacar\n2:Defender\n3:Esquivar");

            //Bucle para elegir acción
            while(accionP < 1 || accionP > 3){
                accionP = keyboard.nextInt();
                //MENSAJE!!!!!!!!!!!!!!!!!!!!
            }

            accionM = random.nextInt(3) + 1;

            if(pasaAlgo(accionP, accionM))
            {

                if(accionP == 1)
                {
                    playerAtaca(accionM);
                }
                else
                {
                    monstruoAtaca(accionP);
                }
            }
            else
            {
                System.out.println("\nAmbos actuáis con cautela...");
            }

            if(PlayerHP <= 0 || MonsterHP <= 0){
                fin = true;
            }
        }

        if(MonsterHP <= 0)
        {
            Personaje playerGana = new Personaje(PlayerName, PlayerAD, PlayerDP, PlayerSpeed, PlayerHP);
            return(playerGana);
        }
        else
        {
            Monstruo monstruoGana = new Monstruo(MonsterName, MonsterAD, MonsterDP, MonsterSpeed, MonsterHP);
            return(monstruoGana);
        }
    }



    //MÉTODOS AUXILIARES

    private boolean pasaAlgo(int aux_accionP,int aux_accionM)
    {
        if (aux_accionM == 1 || aux_accionP == 1)
        {
            return(true);
        }
        else return false;
    }

    private void playerAtaca(int aux_accionM)
    {
        switch (aux_accionM)
        {
            case 1:
                if (PlayerSpeed > MonsterSpeed)
                {
                    MonsterHP = MonsterHP - PlayerAD;
                    PlayerHP = PlayerHP - (MonsterAD / 2);
                    System.out.println("\n¡Atacas antes que " + MonsterName + " y le haces daño!");
                }
                else
                {
                    PlayerHP = PlayerHP - (2 * MonsterAD);
                    System.out.println("\n¡Atacas a " + MonsterName + "! Pero él ha sido más rápido");
                }
                break;
            case 2:
                MonsterHP = MonsterHP - (PlayerAD - MonsterDP);
                System.out.println("\n¡Atacas a " + MonsterName + " y él opta por defenderse de ti!");
                break;
            case 3:
                if(esquivar(MonsterSpeed))
                {
                    System.out.println("\n¡" + MonsterName+" ha evadido el ataque!");
                }
                else
                {
                    MonsterHP = MonsterHP - MonsterAD;
                    System.out.println("\n¡" + MonsterName + " no ha podido esquivar el ataque y lo has herido!");
                }
                break;
        }
    }

    private void monstruoAtaca(int aux_accionP)
    {
        switch (aux_accionP)
        {
            case 2:
                PlayerHP = PlayerHP - (MonsterAD - PlayerDP);
                System.out.println("\n¡" + MonsterName + " te ha atacado, pero te has defendido!");
                break;
            case 3:
                if(esquivar(PlayerSpeed))
                {
                    System.out.println("\n¡" + MonsterName + " te ha atacado, pero has evadido el ataque!");
                }
                else
                {
                    PlayerHP=PlayerHP-MonsterAD;
                    System.out.println("\n¡No has podido esquivar el ataque de " + MonsterName + " y te ha herido!");
                }
                break;
        }

    }

    private boolean esquivar(int vel_evasor)
    {
        Random probEsquive = new Random();
        int auxEsquive = probEsquive.nextInt(vel_evasor) + 1;
        if (auxEsquive > 15)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
