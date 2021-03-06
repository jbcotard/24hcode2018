package org.mixiteam.daycode.antseed;

import io.vertx.core.json.Json;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        //System.out.println("response : " + conn.getResponseCode());

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

        //System.out.println("response : " + conn.getResponseCode());

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
     * @return
     */
    public static List<Seed> searchSeed(String token/*, int numeroGraine*/) throws IOException {
        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/Seeds/search");


        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        //System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);

        Seed[] listeSeed = Json.decodeValue(tokenBuilder.toString(), Seed[].class);
        //Seed seed = listeSeed[numeroGraine];
        //System.out.println(seed.toString());

        //Position positionSeed = new Position(seed.getLocation().getCoordinates()[0], seed.getLocation().getCoordinates()[1]);

        return Arrays.asList(listeSeed);
    }

    /**
     * creation d'un track.
     *
     * @param token
     * @param idSeedStart
     * @param idSeedEnd
     * @param numeroFourmis
     * @return
     */
    public static Track createTrack(String token, String idSeedStart, String idSeedEnd, int numeroFourmis) throws IOException {

        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/tracks");
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("name", "violet " + numeroFourmis);
        params.put("info", "violet " + numeroFourmis + " startSeedId : "
         + idSeedStart + " endSeedId : " + idSeedEnd);
        params.put("startSeedId", idSeedStart);
        params.put("endSeedId", idSeedEnd);
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
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        //System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);

        return Json.decodeValue(tokenBuilder.toString(), Track.class);
    }

    /**
     * creation bulk des positions du track.
     *
     * @param token
     * @param trackId
     * @param listePositionsTrajet
     */
    public static void bulkCreatePositions(String token, String trackId, List<Position> listePositionsTrajet) throws IOException {


        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/positions/bulk");
        //Map<String,Object> params = new LinkedHashMap<>();
        //params.put("trackId", trackId);


        List<PositionWithFloat> listePositionsWithDouble = listePositionsTrajet.stream().map(p ->
            new PositionWithFloat(p)
        ).collect(Collectors.toList());

        String arrayPositions = Json.encode(listePositionsWithDouble.toArray());

        //params.put("positions", arrayPositions);

        String json = "{\"trackId\":\"" + trackId + "\", \"positions\":" + arrayPositions + "}";



        /*StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
*/
        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        //conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        //conn.getOutputStream().write(json);
        //Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
        //writer.write(json);

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();

        //System.out.println("# bulkCreatePositions : response : " + conn.getResponseCode());
        //System.out.println("# bulkCreatePositions : response : " + conn.getResponseMessage());


    }

    /**
     * termine l'enregistrement du track.
     *
     * @param token
     * @param trackId
     * @return
     */
    public static Track endTrack(String token, String trackId, int numeroFourmis) throws IOException {

        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/tracks/" + trackId + "/end");
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("name", "violet " + numeroFourmis);
        params.put("info", "violet " + numeroFourmis);

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        //System.out.println("response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);

        return Json.decodeValue(tokenBuilder.toString(), Track.class);
    }

    /**
     * recuperation des tracks des autres teams.
     *
     * @param token
     * @return
     */
    public static List<Track> getTracksOtherTeams(String token) throws IOException {

        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/tracks/otherTeams");


        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        //System.out.println(" # getTracksOtherTeams response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);

        Track[] listeTrack = Json.decodeValue(tokenBuilder.toString(), Track[].class);
        return Arrays.asList(listeTrack);
    }

    /**
     * recuperation des positions d'un track.
     * @param token
     * @param trackId
     */
    public static List<Position> getPositionsOfTrack(String token, String trackId) throws IOException {
        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/tracks/" + trackId + "/positions");


        HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);

        //System.out.println("# getPositionsOfTrack response : " + conn.getResponseCode());

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        StringBuilder tokenBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            tokenBuilder.append((char)c);

        Position[] listePosition = Json.decodeValue(tokenBuilder.toString(), Position[].class);
        return Arrays.asList(listePosition);
    }

    /**
     *
     * @param token
     * @param trackId
     * @param positionId
     */
    public static void createCicadaAnalyse(String token, String trackId, String positionId) throws IOException {

        URL urlClient = new URL("https://f24h2018.herokuapp.com/api/analyses");
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("trackId", trackId);
        params.put("positionId", positionId);
        params.put("description", "depassement de vitesse  : > 50");

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
        conn.setRequestProperty("Authorization", "Bearer " + token);
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        //System.out.println(" # createCicadaAnalyse response : " + conn.getResponseCode());


    }
}
