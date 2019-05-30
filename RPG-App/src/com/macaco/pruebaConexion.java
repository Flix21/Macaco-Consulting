package com.macaco;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class pruebaConexion {

    static HttpClient client = null;
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    static Ranking r = null;

    public static void main(String[] args)  throws InterruptedException {
        getRanking();

    }


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

    }

}
