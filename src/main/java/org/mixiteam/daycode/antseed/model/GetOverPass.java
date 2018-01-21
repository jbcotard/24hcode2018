package org.mixiteam.daycode.antseed.model;

import org.mixiteam.daycode.antseed.Position;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetOverPass {

    /**
     * authentification d'un insecte.
     *
     * @param debut
     * @param fin
     * @return
     */
    public static String auth(Position debut, Position fin) throws IOException {

        //URL urlClient = new URL("http://http://overpass-turbo.eu/");

        double lat1 = Double.valueOf( debut.getLat());
        double lat2 = Double.valueOf( fin.getLat());

        double long1 = Double.valueOf( debut.getLon());
        double long2 = Double.valueOf( fin.getLon());

        String nord = Double.toString( Double.max(lat1, lat2));
        String ouest = Double.toString(Double.max(long1, long2));

        String sud = Double.toString( Double.min(lat1, lat2));
        String est = Double.toString(Double.min(long1, long2));
        
        String position=sud+","+est+","+nord+","+ouest;

        String url = "[out:json];way("+position+")[highway~\"^(motorway|residential|trunk|primary|secondary|tertiary|(motorway|trunk|primary|secondary|residential)_link)$\"];(._;>;);out;";

        URL urlClient = new URL("http://overpass-api.de/api/interpreter?" + url );

        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);

        System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);


        return tokenBuilder.toString();
    }


    public static void main (String[] args){
        Position depart=new Position("47.9844782", "0.2415538", null);

        Position arrivee=new Position( "47.99026", "0.23991", null);

        try {
            System.out.printf("" +  GetOverPass.auth(depart, arrivee) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
