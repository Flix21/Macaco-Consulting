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
        introduction();
        choosePath(0);

        System.out.print("                                             __----~~~~~~~~~~~------___\n");
        System.out.print("                                  .  .   ~~//====......          __--~ ~~\n");
        System.out.print("                  -.            \\_|//     |||\\\\  ~~~~~~::::... /~\n");
        System.out.print("               ___-==_       _-~o~  \\/    |||  \\\\            _/~~-\n");
        System.out.print("       __---~~~.==~||\\=_    -_--~/_-~|-   |\\\\   \\\\        _/~\n");
        System.out.print("   _-~~     .=~    |  \\\\-_    '-~7  /-   /  ||    \\      /\n");
        System.out.print(" .~       .~       |   \\\\ -_    /  /-   /   ||      \\   /\n");
        System.out.print("/  ____  /         |     \\\\ ~-_/  /|- _/   .||       \\ /\n");
        System.out.print("|~~    ~~|--~~~~--_ \\     ~==-/   | \\~--===~~        .\\\n");
        System.out.print("         '         ~-|      /|    |-~\\~~       __--~~\n");
        System.out.print("                     |-~~-_/ |    |   ~\\_   _-~            /\\\n");
        System.out.print("                          /  \\     \\__   \\/~                \\__\n");
        System.out.print("                      _--~ _/ | .-~~____--~-/                  ~~==.\n");
        System.out.print("                     ((->/~   '.|||' -_|    ~~-/ ,              . _||\n");
        System.out.print("                                -_     ~\\      ~~---l__i__i__i--~~_/\n");
        System.out.print("                                _-~-__   ~)  \\--______________--~~\n");
        System.out.print("                              //.-~~~-~_--~- |-------~~~~~~~~\n");
        System.out.print("                                     //.-~~~--\\\n");

    }

    private static void introduction()
    {
        System.out.println(personaje.getNombre() + ", ha estado vagando por la ruta comercial mucho tiempo sin destino.\n" +
                "Tras meses de viaje se encuentra con un poblado, es momento de empezar una nueva vida y\n" +
                "busca el gremio más popular para emprender su primera aventura y hacerse conocer como\n" +
                " un caballero honorable y honrado.\n");
    }

    private static void choosePath(int intentos)
    {
        intentos++;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("En el tablón del gremio se encuentra con tres carteles de misiones que aún no han sido asignadas:\n" +
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
                if(intentos > 1)
                {
                    System.exit(10);
                }
                else
                {
                    System.out.println("¿Me estás tomando el pelo, forastero?");
                    System.out.println("¡Una tontería más y te porhibo la entrada al gremio!");
                    choosePath(intentos);
                }
                break;
        }
        switch (camino)
        {
            case CASTILLO:
                enemy  = Arrays.asList("VAMPIRO", "CABALLERO HUECO", "FANTASMA", "ESQUELETO");
                estancia  = Arrays.asList("PASILLO", "SALÓN", "PATIO", "TORRE", "MAZMORRA");

                warningMessage();
                System.out.println("Te diriges al castillo y ves una puerta enorme en la entrada que se encuentra abierta.\n");

                System.out.print("                           o                    \n");
                System.out.print("                       _---|         _ _ _ _ _ \n");
                System.out.print("                    o   ---|     o   ]-I-I-I-[ \n");
                System.out.print("   _ _ _ _ _ _  _---|      | _---|    \\ ` ' / \n");
                System.out.print("   ]-I-I-I-I-[   ---|      |  ---|    |.   | \n");
                System.out.print("    \\ `   '_/       |     / \\    |    | /^\\| \n");
                System.out.print("     [*]  __|       ^    / ^ \\   ^    | |*|| \n");
                System.out.print("     |__   ,|      / \\  /    `\\ / \\   | ===| \n");
                System.out.print("  ___| ___ ,|__   /    /=_=_=_=\\   \\  |,  _|\n");
                System.out.print("  I_I__I_I__I_I  (====(_________)___|_|____|____\n");
                System.out.print("  \\-\\--|-|--/-/  |     I  [ ]__I I_I__|____I_I_| \n");
                System.out.print("   |[]      '|   | []  |`__  . [  \\-\\--|-|--/-/  \n");
                System.out.print("   |.   | |' |___|_____I___|___I___|---------| \n");
                System.out.print("  / \\| []   .|_|-|_|-|-|_|-|_|-|_|-| []   [] | \n");
                System.out.print(" <===>  |   .|-=-=-=-=-=-=-=-=-=-=-|   |    / \\  \n");
                System.out.print(" ] []|`   [] ||.|.|.|.|.|.|.|.|.|.||-      <===> \n");
                System.out.print(" ] []| ` |   |/////////\\\\\\\\\\\\\\\\\\\\.||__.  | |[] [ \n");
                System.out.print(" <===>     ' ||||| |   |   | ||||.||  []   <===>\n");
                System.out.print("  \\T/  | |-- ||||| | O | O | ||||.|| . |'   \\T/ \n");
                System.out.print("   |      . _||||| |   |   | ||||.|| |     | |\n");
                System.out.print("../|' v . | .|||||/____|____\\|||| /|. . | . ./\n");
                System.out.print(".|//\\............/...........\\........../../\\\\\\\n");

                Scanner keyboardz = new Scanner(System.in);
                keyboardz.nextLine();
                System.out.println("En el camino ves un multitud de huellas muy separadas entre sí, parece que alguien huyó despavorido de éste lugar.");
                System.out.println("Entras por la puerta principal y en el recibidor encuentras una espada larga ensangrentada.\n¿La cojes?");
                System.out.println("         />_________________");
                System.out.println("[########[]_________________>");
                System.out.println("         \\>");
                takeWeapon(keyboard);
                break;
            case BOSQUE:
                enemy  = Arrays.asList("GOBLIN", "TROLL", "FANTASMA", "LICÁNTROPO");
                estancia  = Arrays.asList("CIÉNAGA", "CLARO", "ESPESURA", "SANTUARIO");

                warningMessage();
                System.out.println("Te adentras en el bosque y ves que se empieza a levantar una espesa niebla.\n");

                System.out.print("                                            .__ ._       \\_.\n");
                System.out.print("                                     _, _.  '  \\/   \\.-  /\n");
                System.out.print("                                      \\/     .-_`   // |/     \\,\n");
                System.out.print("                     .-\"\"\"\"-.          \\.   '   \\`. ||  \\.-'  /\n");
                System.out.print("                    F        Y        .-.`-(   _/\\ V/ \\\\//,-' >-'   ._,\n");
                System.out.print("                   F          Y   .__/   `. \\.   ' J   ) ./  / __._/\n");
                System.out.print("                  J         \\, I    '   _/ \\  \\  | |  / /  .'-'.-' `._,\n");
                System.out.print("           (       L   \\_.--.| \\_.      ' .___ `\\: | / .--'.-'\"     \\\n");
                System.out.print("         \\ '\\    .  L   /    \\\\/        ._/`-.`  \\ .'.' .'---./__   '\n");
                System.out.print("    \\__  '\\ ) \\._/   `-.__. ` \\\\_. '   .---.  \\     /  /  ,   `  `\n");
                System.out.print("  --'  \\\\  ): // \\,            `-.`__.'     `- \\  /   / _/-.---.__.- .\n");
                System.out.print("     _.-`.'/ /'\\_, ._     >--.-\"\"'____.--\"`_     '   /.'..' \\   \\   _/`\n");
                System.out.print(" _ .---._\\ \\'/ '__./__.-..  / .-|(    x_.-'___  |   :' /    _..---_' \\\n");
                System.out.print(" .:' /`\\ `. `..'.--'\\      /.' /`-`._  `-,'   ` '   I '_.--'__--..___.--._.-\n");
                System.out.print("     `  `. `\\/'/  _.   _.-'      _.____./ .-.--\"\"-. .-\"    ' _..-.---'   \\\n");
                System.out.print("  -._ .--.\\ / /-./     /   .---'-//.___. .-'       \\__ .--.  `    `.     '`-\n");
                System.out.print(" ,--'/.-. ^.   .-.--.  ` _/    _//     ./   _..   .'  `.    \\ \\    |_.\n");
                System.out.print("    /' | >.   ' | \\._.-       '    _..'  `.' . `.       )    | |\\  `\n");
                System.out.print("  ./ \\ \\'  ) c| /  \\     \\_..  .--'    ,\\ \\_/`  :    )  (`-. `.|`\\\\\n");
                System.out.print("   \\'  / ,-.  | ` ./`  ._/ `\\\\'.--.,-((  `.`.__ |   _/   \\    |)  `--._/`\n");
                System.out.print("______'\\   |  < __________  //'  //  _)   )/-._`.  (,-')  )  / \\_.    /\\. _____\n");
                System.out.print("a:f        |  |        .__./    //  '\\  |//    `.\\ '\\ (  (  <`   ._  '\n");
                System.out.print("           >  |      _.  /   ..-\\ _    _/ \\_.  \\ `\\    \\_ `---.-'__\n");
                System.out.print("        . /  `-   _.'        /   `   _/|       J  /`     `-,,-----.`-.\n");
                System.out.print("            '  .:'          '`      '          < `   f  I //        `\u00AD\\_,\n");
                System.out.print("              '                         \\.     J        I/\\_.        ./\n");
                System.out.print("         __/                            `:     I  .:    K  `          `\n");
                System.out.print("         \\/ )                            `,   J         L\n");
                System.out.print("          )_(_                             .  F  .-'    J\n");
                System.out.print("         /    `.                           .  I  (.   . I _.-.._\n");
                System.out.print("   '    <'    \\ )                     _.---.J/      :'   L -'\n");
                System.out.print(" .:.     \\. _.->/                        _.-'_.)     ` `-.`---.,_.\n");
                System.out.print(":<        (    \\                    .--\"\"   .F' J) `.`L.__`-.___\n");
                System.out.print(".:        |-'\\_.|                          Y ..Z     ))   `--'  `-\n");
                System.out.print(".         ) | > :                            . '    :'\n");
                System.out.print("          / ) L_J                            .x,.\n");
                System.out.print("          L_J .,                             .:<.,\n");
                Scanner keyboardy = new Scanner(System.in);
                keyboardy.nextLine();
                System.out.println("Por el camino encuentras un hacha un muy afilada tirada en el suelo, debe de habersele caido a alguien...");

                System.out.println("  ,  /\\  .  ");
                System.out.print(" //`-||-'\\\\ \n");
                System.out.print("(| -=||=- |)\n");
                System.out.print(" \\\\,-||-.// \n");
                System.out.print("  `  ||  '  \n");
                System.out.print("     ||     \n");
                System.out.print("     ||     \n");
                System.out.print("     ||     \n");
                System.out.print("     ||     \n");
                System.out.print("     ||     \n");
                System.out.print("     ()\n");

                System.out.println("¿La cojes?");
                takeWeapon(keyboard);
                break;
            case CUEVA:
                enemy  = Arrays.asList("GOBLIN", "TROLL", "OSO SALVAJE", "ESQUELETO");
                estancia  = Arrays.asList("ENTRADA", "GALERÍA", "GALERÍA OSCURA", "GALERÍA DE LA LUNA");

                warningMessage();
                System.out.println("Te diriges a las montañas al norte del poblado en busca de la cueva y tras varias leguas\n" +
                                    "encuentras la entrada con señales de lucha en el interior.\n");

                System.out.print("                    /   \\              /'\\       _                              \n");
                System.out.print("\\_..           /'.,/     \\_         .,'   \\     / \\_                            \n");
                System.out.print("    \\         /            \\      /       \\  /    \\     _                     \n");
                System.out.print("     \\__,.   /              \\    /           \\/.,   _|  _/ \\                    \n");
                System.out.print("          \\_/                \\  /',.,''\\      \\_ \\_/  \\/    \\                   \n");
                System.out.print("                           _  \\/   /    ',../',.\\    _/      \\                  \n");
                System.out.print("             /           _/m\\  \\  /    |         \\  /.,/'\\   _\\                 \n");
                System.out.print("           /           /MMmm\\  \\     |          \\/      \\_/  \\                \n");
                System.out.print("          /      \\     |MMMMmm|   \\__   \\          \\_       \\   \\_              \n");
                System.out.print("                  \\   /MMMMMMm|      \\   \\           \\       \\    \\             \n");
                System.out.print("                   \\  |MMMMMMmm\\      \\__            \\      \\_   \\            \n");
                System.out.print("                    \\|MMMMMMMMmm|_.'  /\\            \\       \\   \\_          \n");
                System.out.print("                    /'.,_____...,,'   \\            \\   \\        \\         \n");
                System.out.print("                   /       \\          |      \\    |_     \\   \\       \\        \n");
                System.out.print("                 /        |           \\      \\     \\     \\    \\       \\_      \n");
                System.out.print("                /                               \\     \\     \\_   \\        \\     \n");
                System.out.print("                                                 \\     \\      \\   \\__      \\    \n");
                System.out.print("                                                  \\     \\_     \\     \\      \\   \n");
                System.out.print("                                                   |      \\     \\     \\      \\  \n");
                System.out.print("                                                    \\            |            \\ \n");
                Scanner keyboardx = new Scanner(System.in);
                keyboardx.nextLine();
                System.out.println("Entras y ves en el suelo una maza y seguidamente un rastro...\n");

                System.out.print("        |\\\n");
                System.out.print("        | \\        /|\n");
                System.out.print("        |  \\__  / |\n");
                System.out.print("       /|__/AMMA\\/  |\n");
                System.out.print("     /AMMMMMMMMMMM\\_|\n");
                System.out.print(" _/AMMMMMMMMMMMMMMA\n");
                System.out.print(" \\   |MVKMMM/ .\\MMMMM\\\n");
                System.out.print("  \\__/MMMMMM\\  /MMMMMM---\n");
                System.out.print("  |MMMMMMMMMMMMMMMMMM|  /\n");
                System.out.print("  |MMMM/. \\MM.--MMMMMM\\/\n");
                System.out.print("  /\\MMM\\  /MM\\  |MMMMMM   _\n");
                System.out.print(" /  |MMMMMMMMM\\ |MMMMMM--/   \\-.\n");
                System.out.print("/_/MMMMMMMMMM\\|M.--M/_/_|   \\\n");
                System.out.print("     \\VMM/\\MMMMMMM\\  |      /\\ \\/\n");
                System.out.print("      \\V/  \\MMMMMMM\\ |     /_  /\n");
                System.out.print("        |  /MMMV'   \\|    |/ _/\n");
                System.out.print("        | /              _/  /\n");
                System.out.print("        |/              /| \\'\n");
                System.out.print("                       /_  /\n");
                System.out.print("                       /  /\n");
                System.out.print("                      /  /\n");

                System.out.println("¿La coges?");
                takeWeapon(keyboard);
                break;
        }

    }

    private static void warningMessage()
    {
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

    private static void takeWeapon(Scanner keyboard)
    {
        System.out.println("[1] SI      [2] NO");
        switch (keyboard.nextInt())
        {
            case 1:
                personaje.setAtaque(personaje.getAtaque() + 10);
                personaje.setVelocidad(personaje.getVelocidad() - 5);
                personaje.setWeapon(true);
                System.out.println("Sabia decisión, has ganado 10 puntos de ataque.");
                System.out.println("Pero el arma pesa bastante y pierdes 5 puntos de velocidad");
                System.out.println("Puntos actuales\n" + personaje.getAtaque()+"\n"+ personaje.getDefensa()+
                                    "\n"+ personaje.getVelocidad() + "\n" + personaje.getSalud());
                nextPlace(keyboard);
                break;
            case 2:
                nextPlace(keyboard);
                break;
            default:
                nextPlace(keyboard);
                break;
        }
    }

    private static void nextPlace(Scanner keyboard)
    {
        checkEnemyBattle();
        System.out.println("Ha habido una batalla muy reciente que se cobró la vida de un valeroso caballero\n" +
                            "antes de que " + personaje.getNombre() + " llegase...\n ");
        System.out.println("Parece que su armadura aún está en buen estado, no es de buen augurio profanar un cadaver\n" +
                            "pero no completar la aventura supondría un grave peligro para los habitantes.\n");
        System.out.println("¿Coges la armadura?\n");
        System.out.print("              {}\n");
        System.out.print("             .--.\n");
        System.out.print("            /.--.\\\n");
        System.out.print("            |====|\n");
        System.out.print("            |`::`|\n");
        System.out.print("        .-;`\\..../`;-.\n");
        System.out.print("       /  |...::...|  \\\n");
        System.out.print("      |   /'''::'''\\   |\n");
        System.out.print("      ;--'\\   ::   /\\--;\n");
        System.out.print("      <_>,>.::.<,<_>\n");
        System.out.print("      |  |/   ^^   \\|  |\n");
        System.out.print("      \\::/|        |\\::/\n");
        System.out.print("      |||\\|        |/|||\n");
        System.out.print("      ''' |_/\\___| '''\n");
        System.out.print("           \\_ || _/\n");
        System.out.print("           <_ >< _>\n");
        System.out.print("           |  ||  |\n");
        System.out.print("           |  ||  |\n");
        System.out.print("          \\.:||:./\n");
        System.out.print("         /_/\\_\\\n");
        System.out.println("[1] SI      [2] NO");
        switch (keyboard.nextInt())
        {
            case 1:
                personaje.setDefensa(personaje.getDefensa() + 10);
                personaje.setVelocidad(personaje.getVelocidad() - 5);
                personaje.setWeapon(true);
                System.out.println("Sabia decisión, has ganado 10 puntos de defensa.");
                System.out.println("Pero la armadura pesa bastante y pierdes 5 puntos de velocidad");
                System.out.println("Puntos actuales\n" + personaje.getAtaque()+"\n"+ personaje.getDefensa()+
                        "\n"+ personaje.getVelocidad() + "\n" + personaje.getSalud());
                break;
            case 2:
                nextPlace(keyboard);
                break;
            default:
                nextPlace(keyboard);
                break;
        }
    }

    private static void checkEnemyBattle()
    {
        int randEnemy = randomRange(1,5);
        if(randEnemy >= 4)
        {
//            startBattle();
        }
    }

    private static void startBattle(Entidad entity)
    {

    }

    private static void endGame(Entidad entity)
    {
        if(entity instanceof Monstruo)
        {
            System.out.print("   ____                                     \n");
            System.out.print("  6MMMMb/                                   \n");
            System.out.print(" 8P    YM                                   \n");
            System.out.print("6M      Y    ___    ___  __    __     ____  \n");
            System.out.print("MM         6MMMMb   `MM 6MMb  6MMb   6MMMMb \n");
            System.out.print("MM        8M'  `Mb   MM69 `MM69 `Mb 6M'  `Mb\n");
            System.out.print("MM     ___    ,oMM   MM'   MM'   MM MM    MM\n");
            System.out.print("MM     `M',6MM9'MM   MM    MM    MM MMMMMMMM\n");
            System.out.print("YM      M MM'   MM   MM    MM    MM MM      \n");
            System.out.print(" 8b    d9 MM.  ,MM   MM    MM    MM YM    d9\n");
            System.out.print("  YMMMM9  `YMMM9'Yb._MM_  _MM_  _MM_ YMMMM9 \n\n");
            System.out.print("     ____                                \n");
            System.out.print("    6MMMMb                               \n");
            System.out.print("   8P    Y8                              \n");
            System.out.print("  6M      Mb ____    ___   ____   ___  __\n");
            System.out.print("  MM      MM `MM(    )M'  6MMMMb  `MM 6MM\n");
            System.out.print("  MM      MM  `Mb    d'  6M'  `Mb  MM69 \"\n");
            System.out.print("  MM      MM   YM.  ,P   MM    MM  MM'   \n");
            System.out.print("  MM      MM    MM  M    MMMMMMMM  MM    \n");
            System.out.print("  YM      M9    `Mbd'    MM        MM    \n");
            System.out.print("   8b    d8      YMP     YM    d9  MM    \n");
            System.out.print("    YMMMM9        M       YMMMM9  _MM_   \n");
        }
        else
        {
            //AGREGAR JUGADOR A LA BBDD
        }
        //Para saber el tiempo de juego
        //System.out.println(GameTimer.getPlayTime());
    }

    private static Personaje createPlayer()
    {
        System.out.println("Bienvenido a Macaco. Dinos tu nombre...");
        Scanner keyboard_nombre = new Scanner(System.in);
        personaje = new Personaje();
      String nombre = keyboard_nombre.nextLine();
      if(nombre.length()<=10 && nombre.length()>=3){
        personaje.setNombre(nombre);}
      else{
          if (nombre.length()>10 ){
          System.out.println("Nombre demasiado largo, debes poner un nombre mas corto.");}
          else{
          System.out.println("Seguro que no te llamas así, dime un nombre mas largo");
      }
          Main.createPlayer();
      }

        System.out.println("Muy bien " + personaje.getNombre() + ", ¡prepárate para la aventura!");
        int puntos=50;
        System.out.println("Tienes 50 puntos para ser distribuidos entre los atributos Ataque, Defensa y Velocidad");

        String[] atributos = {"ataque", "defensa", "velocidad"};
        Integer[] puntaje_atributos= new Integer[3];

        for (int i = 0; puntos > 0; i++) {
            System.out.println("¿Cuántos puntos de los " + puntos + " quieres añadirle a " + atributos[i] + "?");
            Scanner keyboard = new Scanner(System.in);
            String puntos_agregados = keyboard.nextLine();
            if (puntos_agregados.matches("[0-9]+") && puntos_agregados.length() >= 1) {
                if (Integer.parseInt(puntos_agregados) <= puntos) {
                    puntos = puntos - (Integer.parseInt(puntos_agregados));
                    puntaje_atributos[i] = Integer.parseInt(puntos_agregados);
                } else {
                    System.out.println("Te has pasado de los 50 puntos, no eres digno para jugar Macaco...");
                    System.exit(10);
                    break;
                }
            } else {
                System.out.println("¡Solo numeros!");
                Main.createPlayer();
            }
        }
        if (puntaje_atributos[0] != null) {
            personaje.ataque = puntaje_atributos[0]+10;
        } else {personaje.ataque = 10;}
        if (puntaje_atributos[1] != null) {
            personaje.defensa = puntaje_atributos[1]+10;
        }else {personaje.defensa = 10;}
        if (puntaje_atributos[2] != null) {
            personaje.velocidad = puntaje_atributos[2]+10;
        }else {personaje.velocidad = 10;}
        System.out.println("Perfecto " + personaje.nombre + ", tienes " + personaje.ataque + " puntos de ataque, "
                + personaje.defensa + " de defensa, " + personaje.velocidad + " de velocidad y "
                + personaje.getSalud() + " puntos de salud");
    return personaje;
    }


    private static int randomRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}