package com.macaco;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class Conexion {

    static HttpClient client = null;
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    static Ranking r = null;

    public Conexion() { }


    public static void getRanking() {

        client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8080/rpgrestful_war_exploded/API");
        try {
            HttpResponse response = client.execute(get);

            String entity = EntityUtils.toString(response.getEntity());
            r = JSON_MAPPER.readValue(entity, Ranking.class);

        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Fecha: " + r.fecha.toString());
        System.out.println("Tiempo: " + r.tiempo);
        System.out.println("Nombre: " + r.nombre);
        System.out.println("Ataque: " + r.ataque);
        System.out.println("Defensa: " + r.defensa);
        System.out.println("Velocidad: " + r.velocidad);
        System.out.println("Puntos de vida: " + r.vida);
        System.out.println("Monstruo: " + r.monstruo);
        System.out.println("");
    }

    public static void postRanking(String nombre, String av_partida, String fecha, String tiempo, String monstruo, String ataque, String defensa, String velocidad, String vida) {
        client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/rpgrestful_war_exploded/API");

        r = new Ranking(nombre, av_partida, fecha, tiempo, monstruo, ataque, defensa, velocidad, vida);

        try {
            String json = JSON_MAPPER.writeValueAsString(r);
            StringEntity entity = new StringEntity(json);

            post.setEntity(entity);
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");
            post.setHeader("valores", json);

            HttpResponse response = client.execute(post);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
