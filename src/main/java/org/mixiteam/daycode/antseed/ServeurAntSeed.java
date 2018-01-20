package org.mixiteam.daycode.antseed;

import io.vertx.core.http.HttpClient;
import io.vertx.core.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServeurAntSeed {

    /**
     * authentification d'un insecte.
     *
     * @param email
     * @param password
     * @return
     */
    public static String auth(String email, String password) throws IOException {

        String token = null;

        URL urlClient = new URL("https://f24h2018.herokuapp.com/auth/local");
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("password", password);
        params.put("email", email);
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);



        return Json.decodeValue(tokenBuilder.toString(), Token.class).getToken();
    }


    /**
     * recuperation position insecte.
     *
     * @param token
     * @return
     * @throws IOException
     */
    public static Position getUserMe(String token) throws IOException {


        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/users/me");


        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);

        Insecte fourmis = Json.decodeValue(tokenBuilder.toString(), Insecte.class);
        Position positionFourmis = new Position(fourmis.getLat(), fourmis.getLon());

        return positionFourmis;
    }

    /**
     * recuperation position graine.
     *
     *
     * @param token
     * @param numeroGraine
     * @return
     */
    public static Position searchSeed(String token, int numeroGraine) throws IOException {
        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/Seeds/search");


        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);

        Seed[] listeSeed = Json.decodeValue(tokenBuilder.toString(), Seed[].class);
        Seed seed = listeSeed[numeroGraine];
        System.out.println(seed.toString());

        Position positionSeed = new Position(seed.getLocation().getCoordinates()[0], seed.getLocation().getCoordinates()[1]);

        return positionSeed;
    }
}
