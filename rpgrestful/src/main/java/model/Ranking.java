package model;

import java.sql.Date;

public class Ranking {

    public String nombre;
    public int av_partida;
    public Date fecha;
    public float tiempo;
    public String monstruo;
    public int ataque;
    public int defensa;
    public int velocidad;
    public int vida;

    public Ranking() { }

    public Ranking(String nombre, String av_partida, String fecha, String tiempo, String monstruo, String ataque, String defensa, String velocidad, String vida) {
        this.nombre = nombre;
        this.av_partida = Integer.parseInt(av_partida);
        this.fecha = Date.valueOf(fecha);
        this.tiempo = Float.parseFloat(tiempo);
        this.monstruo = monstruo;
        this.ataque = Integer.parseInt(ataque);
        this.defensa = Integer.parseInt(defensa);
        this.velocidad = Integer.parseInt(velocidad);
        this.vida = Integer.parseInt(vida);
    }
}
