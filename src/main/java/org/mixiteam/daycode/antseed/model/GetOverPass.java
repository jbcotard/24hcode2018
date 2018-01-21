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
    public static String getWayOverPass(Position debut, Position fin) throws IOException {

        //URL urlClient = new URL("http://http://overpass-turbo.eu/");

    	double delta=0.009;
        double lat1 = Double.valueOf( debut.getLat());
        double lat2 = Double.valueOf( fin.getLat());

        double long1 = Double.valueOf( debut.getLon());
        double long2 = Double.valueOf( fin.getLon());

        String nord = Double.toString( Double.max(lat1, lat2)+delta);
        String ouest = Double.toString(Double.max(long1, long2)+delta);

        String sud = Double.toString( Double.min(lat1, lat2)-delta);
        String est = Double.toString(Double.min(long1, long2)-delta);
        String position=sud+","+est+","+nord+","+ouest;

        String url = "[out:json];way("+position+")[highway~\"^(motorway|residential|trunk|primary|secondary|tertiary|(motorway|trunk|primary|secondary|residential)_link)$\"];(._;>;);out;";

        URL urlClient = new URL("http://overpass-api.de/api/interpreter?" + url );

        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);

        //System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);


        return tokenBuilder.toString();
    }

}
